<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Teacher Details</h2>
	<br>
	<form action="AddTeacherServlet" method="post">
		Enter the Teacher Name:<input type="text" name="teacher_name"><br><br>
		Enter the Teacher ID: <input type="number" name="teacher_id"><br><br>
		Enter the Age: <input type="number" name="age"><br><br>
		<button type="submit">Add</button>
	</form><br><br><hr>
	<a href="learnersAcademy.jsp"><button>Back</button></a>
</body>
</html>