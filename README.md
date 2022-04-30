# Developing-a-Backend-Admin-for-Learners-Academy

# PROJECT NAME: Developing a Backend Admin    for Learner’s Academy

## DEVELOPER NAME: AZHAGARASAN.A

### PROJECT DESCRIPTION:
As a Full Stack Developer, design and develop a backend administrative portal for the Learner’s Academy. Use the GitHub repository to manage the project artifacts. 
Learner’s Academy is a school that has an online management system. The system keeps track of its classes, subjects, students, and teachers. It has a back-office application with a single administrator login. 
The administrator can:
● Set up a master list of all the subjects for all the classes
● Set up a master list of all the teachers
● Set up a master list of all the classes
● Assign classes for subjects from the master list
● Assign teachers to a class for a subject (A teacher can be assigned to different classes for different subjects)
● Get a master list of students (Each student must be assigned to a single class)
There will be an option to view a Class Report which will show all the information about the class, such as the list of students, subjects, and teachers
     

### SPRINT PLANING: 3 Sprint (6 weeks)
	
***Sprint 1:***
	Setup login servlet, Database and master list for all entities.
•	Classes and Student.
•	Teacher
•	Subject

***Sprint 2:***
		Implement Assigning operations(Mapping relationship)
•	Classes to Student
•	Teachers to Classes.
•	Subject to Classes.

***Sprint 3:***
	Display the
•	Master list of Student
•	Class Report
Improvement in the navigation.
		Logout.

### Algorithm:
•	Start the program
•	Enter the username and password to login form
•	It goes into login servlet and check whether the given user name and password is correct or not
•	If username and password is correct it enters into dashboard  
•	Else it will shows error message like username or password is incorrect
•	In dashboard it will display Welcome screen with username.
•	And also it will display the adding, assigning, class report and logout option.
•	 Choose add class and student option it will generate form of add class and student detail
•	Fill the form and click the add button
•	It will go to servlet get connection from database using hibernate, add the class and student details to its respective pojo class and also add to database in two separate tables.
•	And also made one to one relationship between this two tables.
•	 Return to adding form page.
•	And click the back button it will redirected to home page which is dash board.
•	Choose add Teacher option it will generate form to add teacher details
•	Fill the form and click the add button
•	It will go to servlet get connection from database using hibernate, add the Teacher details to its respective pojo class and also add to database in the separate table.
•	And it Returns to adding form page again.
•	Click the back button it will redirected to home page which is dash board.
•	Choose add Subject option it will generate the form to add Subject details
•	Fill the form and click the add button
•	It will go to servlet get connection from database using hibernate, add the Subject details to its respective pojo class and also add to database in the separate table.
•	And it Returns to adding form page again.
•	Click the back button it will redirected to home page which is dash board.
•	Choose assign Teacher option it will go to assigning teacher page and generate available classes list which means no one assigned to that classes.
•	And also Teacher list with id will generate.
•	Give the id of classes and teacher and click the assign button
•	It will go to servlet get the data base connection using hibernate and assign teacher to classes
•	And it Returns to assigning form page
•	Click the back button it will redirected to homepage which is dashboard
•	Choose assign Subject option it will go to assigning subject page and generate available classes list which means no one assigned to that classes.
•	And also Subject list with id will generate.
•	Give the id of classes and subject and click the assign button
•	It will go to servlet get the data base connection using hibernate and assign subject to classes
•	And it Returns to assigning form page
•	Click the back button it will redirected to homepage which is dashboard
•	 Click Get Student List it will go to servlet get the connection from database
•	And get the list of students and classes which assigned
•	And display the students list with their respective classes
•	Returns to home page
•	Click Class repot it will go to servlet get the connection from database
•	And get the list of students and classes, Teacher list, subject list, Teacher and subject who are assigned  to classes list.
•	And display the all the above list with their respective classes
•	Returns to home page
•	Click the Logout button it will logged out and return to starting login form page.
•	Stop the Program
Concepts used in this project are Encapsulation, Polymorphism, Collections, servlets, HttpSession, RequestDispatcher, PrintWriter, sendRedirect.

### Tools used:
•	MySql
•	Hibernate
•	Ecllipse IDE-Java EE
•	Servlet/JSP/HTML
•	Tomcat Server
