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
	<jsp:useBean id="lb" class="beans.LoginBean" scope="session"/>
	<jsp:setProperty name="lb" property="*" />
	${lb.authenticate()}
	<c:choose>
		<c:when test="${empty lb.user}">
			Invalid email or password. <br/><br/>
			<a href="index.jsp">Login Again</a>
		</c:when>
		<c:when test="${lb.user.role == 'admin'}">
			<c:redirect url="result.jsp"/>
		</c:when>
		<c:when test="${lb.user.role == 'voter'}">
			<c:redirect url="candlist.jsp"/>
		</c:when>
		<c:otherwise>
			<c:redirect url="index.jsp"/>
		</c:otherwise>
	</c:choose>
	
</body>
</html>