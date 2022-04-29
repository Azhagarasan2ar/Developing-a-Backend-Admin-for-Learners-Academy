package com.subjects;

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
 * Servlet implementation class AssingingSubjectServlet
 */
@WebServlet("/AssingingSubjectServlet")
public class AssingingSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssingingSubjectServlet() {
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
		
			int subjectID=Integer.parseInt(request.getParameter("subject_id"));
			int classID=Integer.parseInt(request.getParameter("class_id"));
			
			Subject subject=(Subject)sessionHibernate.get(Subject.class, subjectID);
			Classes classes=(Classes)sessionHibernate.get(Classes.class, classID);
			
			classes.setSubject(subject);
			
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
			
			response.sendRedirect("AssignSubject");
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("AssignSubject");
		}
		
	}

}
