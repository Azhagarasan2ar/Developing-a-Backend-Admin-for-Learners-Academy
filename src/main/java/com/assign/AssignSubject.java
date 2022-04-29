package com.assign;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.controller.HibernateUtil;
import com.subjects.Subject;
import com.classesAndStudent.Classes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AssignSubject
 */
@WebServlet("/AssignSubject")
public class AssignSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignSubject() {
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
			out.print("<h3>Available class</h3>");
			
			List<Classes> classList = sessionHibernate.createQuery("from Classes").list();	
			
			for(Classes clas:classList)
			{
				if(Objects.isNull(clas.getSubject()))
				{
					
					out.print("<b>Id</b>:"+clas.getClassId()+"  <b>class name:</b> "+clas.getClassName()+"<br>");

				}
			}
			
			out.print("<h3>Available Subject</h3>");
			List<Subject> subjectList=sessionHibernate.createQuery("from Subject").list();
			
			for(Subject sub:subjectList)
			{
				out.print("<b>Id:</b>"+sub.getSubId()+"  <b>subject name:</b> "+sub.getSubjectName()+"<br>");
			}
			sessionHibernate.close();
			out.print("<br><br>");
			out.print("</body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("assignSubject.jsp");
			rd.include(request, response);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("learnersAcademy.jsp");
		}
	}

}
