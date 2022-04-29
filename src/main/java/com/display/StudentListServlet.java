package com.display;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.classesAndStudent.Classes;
import com.classesAndStudent.Student;
import com.controller.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListServlet() {
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
			
			PrintWriter out=response.getWriter();
			out.print("<html><body>");
			out.print("<h2>Students List</h2>");			
			List<?> list=sessionHibernate.createQuery("from Student as stud inner join stud.classes as clas").list();
			for(int i=0;i<list.size();i++)
			{
				Object[] row=(Object[])list.get(i);
				Student student=(Student)row[0];
				Classes classes=(Classes)row[1];
				out.print("<b>Student Id:</b>"+student.getStudId()+" <b>Name:</b>"+student.getStudName()+", <b>Class Name:</b>"+classes.getClassName()+"<br><br>");
			}
			out.print("<hr>");
			out.print("<a href=\"learnersAcademy.jsp\"><button>Back</button></a>");
			
			sessionHibernate.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("learnersAcademy.jsp");

		}
	}

}
