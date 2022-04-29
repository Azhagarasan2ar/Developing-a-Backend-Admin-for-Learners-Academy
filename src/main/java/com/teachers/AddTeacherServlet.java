package com.teachers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.controller.HibernateUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String teacherName=request.getParameter("teacher_name");
		
		
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("addingTeacher.jsp");
		
		
		if(teacherName!=null)
		{
	
			try
			{
				SessionFactory factory=HibernateUtil.getSessionFactory();
				Session sessionHibernate=factory.openSession();
				Transaction transaction=sessionHibernate.beginTransaction();
				
				int teacherID=Integer.parseInt(request.getParameter("teacher_id"));
				int age=Integer.parseInt(request.getParameter("age"));
				
				if(!teacherName.isEmpty()&&teacherID!=0)
				{
					
					
					Teacher teacher=new Teacher();
					teacher.setTeacherID(teacherID);
					teacher.setTeacherName(teacherName);
					teacher.setAge(age);
					
					sessionHibernate.save(teacher);
					
					try
					{
						transaction.commit();
					}
					catch(Exception e)
					{
						transaction.rollback();
					}
					sessionHibernate.close();
					response.sendRedirect("addingTeacher.jsp");
				}
				else
				{
					sessionHibernate.close();
					rd.include(request, response);
					out.print("<span style='color:red'>*Teacher id, name and age should not  be empty</span>");
				}
					
			}
			catch(NumberFormatException e)
			{
				e.printStackTrace();
				rd.include(request, response);
				out.print("<span style='color:red'>*Teacher id, name and age should not  be empty</span>");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				response.sendRedirect("addingTeacher.jsp");
			}

		}
		
		else
		{
			rd.include(request, response);
			out.print("<span style='color:red'>*Teacher id, name and age should not to be null</span>");
		}
	}

}
