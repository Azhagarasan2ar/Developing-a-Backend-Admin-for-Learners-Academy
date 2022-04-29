<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learners Academy-online school</title>
</head>
<body>
	<h1>Learners Academy</h1><hr>
	<%
		HttpSession httpsession=request.getSession(false);
		if(httpsession!=null&&httpsession.getAttribute("user")!=null)
		{
			String userName=(String)httpsession.getAttribute("user");
			out.print("<h2>Welcome "+userName+"</h2>");
			out.print("<br><br>");
		}
	%>
	<br><br>
	<a href="addingClassAndStudent.jsp">Add Class and Students</a><br><br>
	<a href="addingTeacher.jsp">Add Teachers</a><br><br>
	<a href="addingSubject.jsp">Add Subjects</a><br><br>
	<a href="AssignTeacher">Assign Teachers to class</a><br><br>
	<a href="AssignSubject">Assign Subjects</a><br><br>
	<a href="StudentListServlet">Get Student List</a><br><br>
	<a href="ClassReportServlet">Class Report</a><br>
	<br>
	<hr>
	<a href="LogoutServlet"><button>Logout</button></a>
</body>
</html>