<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Subjects</h2>
	<br>
	<form action="AddSubjectServlet" method="post">
		Enter the SubjectName:<input type="text" name="subject_name">
		<button type="submit">Add</button>
	</form><br><br>
	<hr>
	<a href="learnersAcademy.jsp"><button>Back</button></a><br>

</body>
</html>