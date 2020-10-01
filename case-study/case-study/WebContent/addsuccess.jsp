<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Contact Added Successfully.</h3>
	<p>Id: ${contactKey.id}, Name : ${contactKey.name}, Phone: ${contactKey.phone}</p>
	<jsp:include page="contact.jsp"></jsp:include>
</body>
</html>