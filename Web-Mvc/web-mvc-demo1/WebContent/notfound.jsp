<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User Not Found</h1>
	<h3 style = "color:red">${err}</h3>
	<jsp:include page="searchuser.html"></jsp:include>
</body>
</html>