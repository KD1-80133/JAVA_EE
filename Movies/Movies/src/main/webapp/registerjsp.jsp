<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="rb" class="beans.RegisterBean"/>
<jsp:setProperty  name="rb" property="*"/>
	<% rb.saveUser();%>
	
	<% if(rb.getStatus()){
		out.println("User Registered successfully!");
	}else{
		out.println("User not added!");
	}
		%>
</body>
</html>