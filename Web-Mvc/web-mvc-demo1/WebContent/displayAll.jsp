
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
</head>
<body>
	<h3>All the Users</h3>
	<!-- The below word overrides the to string method written in User class -->
	<!-- ${listKey}
	<h3>We are using JSTL</h3>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
	<ol>
		<core:forEach items="${listKey}" var="u">
			<li>Id = ${u.userId}, Name = ${u.name}, Phone=${u.phone}</li>
		</core:forEach>
	</ol>-->
	<div class="container">   
  
<table class="table table-dark">  
  <tr><th>S.No</th><th>Id</th><th>Name</th><th>Phone</th></tr>
  <%!
  int i=1;
  %>  
  <core:forEach items="${listKey}" var="u">
  	<tr><td><%=i %></td><td>${u.userId}</td><td>${u.name}</td><td>${u.phone}</td></tr>
  	<%
  	i=i+1;
  	%>
  </core:forEach>	
</table>  
  
</div>
</body>
</html>