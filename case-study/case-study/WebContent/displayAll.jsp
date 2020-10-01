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


<div class="container">   
  
<table class="table table-dark">  
  <tr><th>Id</th><th>Name</th><th>Phone</th></tr>

  <core:forEach items="${allContactsKey}" var="u">
  	<tr><td>${u.id}</td><td>${u.name}</td><td>${u.phone}</td></tr>
  </core:forEach>	
</table>  
  
</div>
</body>
</html>