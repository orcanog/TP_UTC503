<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier matière</title>
</head>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
	%>
	<form action="matiere" method="post">
		<input type="hidden" name="action" value="modifier">
		<input type="hidden" name="id" value="${id}">
        <label>Nom</label>
        <input type="text" name="nom" required /><br/>

        <label>Nb heures</label>
        <input type="text" name="heure" required /><br/>

        <input type="submit" value="Modifier" />
    </form>
</body>
</html>