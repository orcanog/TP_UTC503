<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<h2>Connexion</h2>
	<p style="color:red;">
        ${erreur != null ? erreur : ""}
    </p>
    <form action="connexion" method="post">
        <label>Login</label>
        <input type="text" name="login" required /><br/>

        <label>Mdp</label>
        <input type="password" name="mdp" required /><br/>

        <input type="submit" value="Ok" />
    </form>
</body>
</html>