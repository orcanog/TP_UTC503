<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter matière</title>
</head>
<body>
	<form action="matiere" method="post">
		<input type="hidden" name="action" value="ajout">
        <label>Nom</label>
        <input type="text" name="nom" required /><br/>

        <label>Nb heures</label>
        <input type="text" name="heure" required /><br/>

        <input type="submit" value="Ajouter" />
    </form>
</body>
</html>