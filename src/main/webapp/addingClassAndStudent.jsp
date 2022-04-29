<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add classes</title>
</head>
<body>
	<h2>ADD Class and Student Details</h2>
	<br>
	<form action="ClassStudentServlet" method="post">
		
		Enter the Class Name:<input type="text" name="class_name"><br><br>
		Enter the Student Name:<input type="text" name="student_name">
		Enter the Student Id:<input type="number" name="student_id"><br>
		
		<hr>
		<h3>Student Details</h3>
		<br>
		Enter the City Name:<input type="text" name="city_name"><br><br>
		Enter the Email address:<input type="email" name="email_add"><br><br>
		<button type="submit">Add</button>
	</form><br><br><hr>
	<a href="learnersAcademy.jsp"><button>Back</button></a>
</body>
</html>