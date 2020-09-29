<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome to Login Success Page</h3>
	<p>Id: ${userKey.userId}, Name : ${userKey.name}, Phone: ${userKey.phone}</p>
	<a href=updatePhone.html>Update Phone Number</a><br/>
	<a href=updatePassword.html>Update Password</a><br/>
	<a href=searchuser.html>Search a User</a><br/>
	<a href=Logout>Logout</a>
</body>
</html>