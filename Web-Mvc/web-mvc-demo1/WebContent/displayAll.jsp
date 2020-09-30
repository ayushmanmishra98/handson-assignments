
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>All the Users</h3>
	${listKey}
	<h3>We are using JSTL</h3>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
	<ol>
		<core:forEach items="${listKey}" var="u">
			<li>Id = ${u.userId}, Name = ${u.name}, Phone=${u.phone}</li>
		</core:forEach>
	</ol>
</body>
</html>