<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello, ${lb.user.firstName} ${lb.user.lastName} <hr/>
	<jsp:useBean id="rb" class="beans.ResultBean"/>
	${rb.fetchResult() }
	<table border="1" class="table">
		<thead class="table-primary">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Party</th>
				<th>Votes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody class="table-danger">
			<c:forEach var="c" items="${rb.candList }">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.party}</td>
					<td>${c.votes}</td>
					<td>
						<a href="editcand.jsp?id=${c.id}">Edit</a>
						<a href="deleteCand.jsp?id=${c.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="logout.jsp">Sign Out</a>
</body>
</html>