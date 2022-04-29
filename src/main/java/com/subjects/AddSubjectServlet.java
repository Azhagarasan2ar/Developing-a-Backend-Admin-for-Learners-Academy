package com.subjects;

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
 * Servlet implementation class AddSubjectServlet
 */
@WebServlet("/AddSubjectServlet")
public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String subjectName=request.getParameter("subject_name");
			
	
			RequestDispatcher rd=request.getRequestDispatcher("addingSubject.jsp");
			PrintWriter out=response.getWriter();
			try
			{
				SessionFactory factory=HibernateUtil.getSessionFactory();
				Session sessionHibernate=factory.openSession();
				Transaction transaction=sessionHibernate.beginTransaction();
				
				if(subjectName!=null&&!subjectName.isEmpty())
				{
					Subject subject=new Subject();
					subject.setSubjectName(subjectName);
					
					sessionHibernate.save(subject);
					try
					{
						transaction.commit();
					}
					catch(Exception e)
					{
						transaction.rollback();
					}
					sessionHibernate.close();
					response.sendRedirect("addingSubject.jsp");
				}
				else
				{
					sessionHibernate.close();
					rd.include(request, response);
					out.print("<span style='color:red'>*subject name should not be empty</span>");
				}
				
			}
					
			catch(Exception e)
			{
				e.printStackTrace();
				response.sendRedirect("addingSubject.jsp");				
			}
			
	}
	
}

