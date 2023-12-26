<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
</head>
<body>
	Hello, ${lb.user.firstName} ${lb.user.lastName} <hr/>
	<h3>Edit Candidate</h3>
	<jsp:useBean id="fcb" class="beans.FindCandidateBean"/>
	<jsp:setProperty name="fcb" property="candId" param="id"/>
	${fcb.fetchCandidate()}
	<form method="post" action="updatecand.jsp">
		<input type="hidden" name="id" value="${fcb.candidate.id}"/> <br/><br/>
		Name: <input type="text" name="name" value="${fcb.candidate.name}"/> <br/><br/>
		Party: <input type="text" name="party" value="${fcb.candidate.party}"/> <br/><br/>
		Votes: <input type="text" name="votes" value="${fcb.candidate.votes}" readonly/> <br/><br/>
		<button type="submit" class="btn btn-primary">Update Candidate</button>
	</form>
</body>
</html>