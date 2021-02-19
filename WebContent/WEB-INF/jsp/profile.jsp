<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/servlet/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="/servlet/assets/css/profile.css">
</head>
<body>
	<label>Roll No : <%= request.getAttribute("rnum") %></label><br>
	<label>Enrollment No : <%= request.getAttribute("enum") %></label><br>
	<label>First Name :<%= request.getAttribute("fname") %></label><br>
	<label>Last Name : <%= request.getAttribute("lname") %></label><br>
	<label>Email Id : <%= request.getAttribute("email") %></label><br>
	<label>Contact : <%= request.getAttribute("city") %></label><br><br>
	<a href="Finduser-2.html" class="link_1 btn btn-outline-secondary">Back</a>
	<a href="index.html" class="link_1 btn btn-outline-success">Home</a>
</body>
</html>