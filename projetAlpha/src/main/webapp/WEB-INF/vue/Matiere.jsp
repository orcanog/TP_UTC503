<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modele.Matiere" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Matières</title>
</head>
<body>
    <h2>${nom != null ? nom : ""}</h2>
	<form action="matiere" method="get">
	    <input type="hidden" name="action" value="ajout">
	    <button type="submit">+ Matière</button>
	</form>
    
    <h2>Liste des matières</h2>

    <%
        Object obj = request.getAttribute("matieres");
        if (obj == null) {
    %>
            <p style="color:red;">Aucune liste de matières n’a été transmise à la page.</p>
    <%
        } else {
            List<Matiere> matieres = (List<Matiere>) obj;

            if (matieres.isEmpty()) {
    %>
                <p>Aucune matière à afficher.</p>
    <%
            } else {
    %>
                <table border="1">
                    <tr>
                        <th>Nom</th>
                        <th>Heures</th>
                    </tr>
                    <%
                        for (Matiere m : matieres) {
                    %>
                        <tr>
                            <td><%= m.getNom() %></td>
                            <td><%= m.getHeure() %></td>
                            <td>
		                        <form action="matiere" method="get" style="display:inline;">
		                            <input type="hidden" name="action" value="modifier">
		                            <input type="hidden" name="id" value="<%= m.getId() %>">
		                            <button type="submit">Modifier</button>
		                        </form>
                    		</td>
                        </tr>
                    <%
                        }
                    %>
                </table>
    <%
            }
        }
    %>
</body>
</html>