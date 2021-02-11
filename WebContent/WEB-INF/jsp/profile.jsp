<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/servlet/assets/css/bootstrap.min.css">
</head>
<body>
	<label>User Id : <%= request.getAttribute("id") %></label><br>
	<label>First Name :<%= request.getAttribute("fname") %></label><br>
	<label>Last Name : <%= request.getAttribute("lname") %></label><br>
	<label>Email Id : <%= request.getAttribute("email") %></label><br>
	<label>Contact : <%= request.getAttribute("contact") %></label><br><br>
	<a href="Finduser.html" class="link_1">Back</a>
	<a href="index.html" class="link_1">Home</a>
</body>
</html>