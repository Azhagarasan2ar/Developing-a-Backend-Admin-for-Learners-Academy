package com.teachers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.classesAndStudent.Classes;
import com.controller.HibernateUtil;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AssingingTeacherServlet
 */
@WebServlet("/AssingingTeacherServlet")
public class AssingingTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssingingTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			SessionFactory factory=HibernateUtil.getSessionFactory();
			Session sessionHibernate=factory.openSession();
			Transaction transaction=sessionHibernate.beginTransaction();
		
			int teacherID=Integer.parseInt(request.getParameter("teacher_id"));
			int classID=Integer.parseInt(request.getParameter("class_id"));
			
			Teacher teacher=(Teacher)sessionHibernate.get(Teacher.class, teacherID);
			Classes classes=(Classes)sessionHibernate.get(Classes.class, classID);
			
			classes.setTeacher(teacher);
			
			sessionHibernate.save(classes);
			
			try
			{
				transaction.commit();
			}
			catch(Exception e)
			{
				transaction.rollback();
				e.printStackTrace();
			}
			sessionHibernate.close();
			response.sendRedirect("AssignTeacher");
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("AssignTeacher");
		}

	}

}
