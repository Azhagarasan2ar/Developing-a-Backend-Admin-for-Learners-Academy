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
import com.subjects.Subject;
import com.teachers.Teacher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClassReportServlet
 */
@WebServlet("/ClassReportServlet")
public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassReportServlet() {
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
			out.print("<h2>Students And Class List</h2>");
			out.print("<br>");
			List<?> SClist=sessionHibernate.createQuery("from Student as stud inner join stud.classes as clas").list();
			for(int i=0;i<SClist.size();i++)
			{
				Object[] row=(Object[])SClist.get(i);
				Student student=(Student)row[0];
				Classes classes=(Classes)row[1];
				out.print("<b>Student Id:</b>"+student.getStudId()+" <b>Name:</b>"+student.getStudName()+", <b>Class Name:</b>"+classes.getClassName()+"<br><br>");
			}
			out.print("<hr>");
			out.print("<h2>Teacher List</h2>");
			out.print("<br>");
			List<Teacher> teacherList=sessionHibernate.createQuery("from Teacher").list();
			for(Teacher teacher:teacherList)
			{
				out.print("<b>Teacher Id:</b>"+teacher.getTeacherID()+" <b>Name:</b>"+teacher.getTeacherName()+"<br><br>");
			}
			out.print("<hr>");
			
			out.print("<h2>Teachers Assinged for Classes</h2>");
			out.print("<br>");
			
			List<?> CTlist=sessionHibernate.createQuery("from Classes as clas inner join clas.teacher").list();
			for(int i=0;i<CTlist.size();i++)
			{
				Object[] row=(Object[])CTlist.get(i);
				Classes classes=(Classes)row[0];
				Teacher teacher=(Teacher)row[1]; 
				out.print("Class:"+classes.getClassName()+",  "+"Teacher:"+teacher.getTeacherName()+"<br><br>");
			}
			out.print("<hr>");
			out.print("<h2>Subject List</h2>");
			out.print("<br>");
			List<Subject> subjectList=sessionHibernate.createQuery("from Subject").list();
			for(Subject subject:subjectList)
			{
				out.print("<b>Subject Name:</b>"+subject.getSubjectName()+"<br><br>");
			}
			out.print("<hr>");
			out.print("<h2>Subjects Assigned for classes</h2>");
			out.print("<br>");
			
			List<?> CSlist=sessionHibernate.createQuery("from Classes as clas inner join clas.subject as sub").list();
			for(int i=0;i<CSlist.size();i++)
			{
				Object[] row=(Object[])CSlist.get(i);
				Classes classes=(Classes)row[0];
				Subject subject=(Subject)row[1]; 
				out.print("<b>Class name:</b>"+classes.getClassName()+", <b>Subject:</b>"+subject.getSubjectName()+"<br><br>");
			}
			out.print("<hr>");
			out.print("<a href=\"learnersAcademy.jsp\"><button>Back</button></a>");
			out.print("</body></html>");
			sessionHibernate.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("learnersAcademy.jsp");
		}

	}

}
