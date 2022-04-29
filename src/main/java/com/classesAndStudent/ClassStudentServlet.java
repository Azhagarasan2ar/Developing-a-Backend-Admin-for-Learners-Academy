package com.classesAndStudent;

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
 * Servlet implementation class ClassStudentServlet
 */
@WebServlet("/ClassStudentServlet")
public class ClassStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String className=request.getParameter("class_name");
		String studentName=request.getParameter("student_name");
		
		
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("addingClassAndStudent.jsp");
		
		
		if(className!=null&&studentName!=null)
		{
			
			try
			{
				SessionFactory factory=HibernateUtil.getSessionFactory();
				Session sessionHibernate=factory.openSession();
				Transaction transaction=sessionHibernate.beginTransaction();
				
				int studentId=Integer.parseInt(request.getParameter("student_id"));
				String cityName=request.getParameter("city_name");
				String emailAdd=request.getParameter("email_add");
				
				if(!className.isEmpty()&&!studentName.isEmpty()&&studentId!=0)
				{
					
					Classes classes=new Classes(className);
					Student student=new Student();
					student.setStudId(studentId);
					student.setStudName(studentName);
					student.setStudCity(cityName);
					student.setEmailAdd(emailAdd);
					student.setClasses(classes);
					
					sessionHibernate.save(classes);
					sessionHibernate.save(student);
					try
					{
						transaction.commit();
					}
					catch(Exception e)
					{
						transaction.rollback();
					}
					
					sessionHibernate.close();
					response.sendRedirect("addingClassAndStudent.jsp");
					
				}
				else
				{
					sessionHibernate.close();
					rd.include(request, response);
					out.print("<span style='color:red'>*Class name, student name should not to be empty</span>");
				}
				
			}
			catch(NumberFormatException e)
			{
				e.printStackTrace();
				rd.include(request, response);
				out.print("<span style='color:red'>*Class name, student name and student id should not to be empty</span>");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				response.sendRedirect("addingClassAndStudent.jsp");
			}

		}
		
		else
		{
			rd.include(request, response);
			out.print("<span style='color:red'>*Class name, student name and student id should not be null</span>");
		}
		
	
	}

}
