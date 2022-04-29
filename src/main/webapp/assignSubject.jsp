<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Assign Subject</h2>
	<br>
	<form action="AssingingSubjectServlet">
		Enter the Subject Id: <input type="number" name="subject_id">
		Enter the Class Id: <input type="number" name="class_id">
		<button type="submit">Assign</button>
	</form><br><br>
	<a href="learnersAcademy.jsp"><button>Back</button></a>
</body>
</html>