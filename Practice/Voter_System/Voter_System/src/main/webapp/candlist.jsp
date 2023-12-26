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
	Hello ,${lb.user.firstName} ${lb.user.lastName } Welcome To Our System <hr/>
	<jsp:useBean id="candbean" class="beans.CandidateListBean"/>
	${candbean.fetchCandidateList() }
	<form method="post" action="vote.jsp">
		<c:forEach var="c" items="${candbean.candList }">
			<input type="radio" name="candidate" value="${c.id}"/> ${c.name} - ${c.party} <br/>
		</c:forEach>
		<input type="submit" value="Vote"/>
	</form>
</body>
</html>