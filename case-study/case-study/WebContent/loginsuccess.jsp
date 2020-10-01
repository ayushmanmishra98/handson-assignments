<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Login Successful</h3>
	<p>Id: ${profileKey.profileId}, Name : ${profileKey.name}, Phone: ${profileKey.phoneNo}, DOB: ${profileKey.DOB}</p>
	<a href=edit.jsp><h4>Edit Profile</h4></a><br/>
	<a href=contact.jsp><h4>Please click here to add Contacts</h4></a><br/>
	<a href=editphone.jsp><h4>Edit Contact Phone</h4></a><br/>
	<a href=editcontactname.jsp><h4>Edit Contact Name</h4></a><br/>
	<a href=getcontact.jsp><h4>Please click here to get Contact Details</h4></a><br/>
	<a href=delete.jsp><h4>Please click here to delete a Contact</h4></a><br/>
	<a href=DeleteProfileServlet><h4>Please click here to delete your Profile</h4></a><br/>
	<a href=DisplayAllContacts><h4>Please click here to display all the contacts</h4></a><br/>
	<a href=Logout><h4>Logout</h4></a>
</body>
</html>