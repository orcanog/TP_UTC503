package fr.esiee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOAcces {
    private Connection connection;

    public DAOAcces(Connection connection) {
        this.connection = connection;
    }

    public void listerAcces() throws SQLException {
        String query = "SELECT id, prenom, login, password, statut, age FROM acces";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.executeUpdate();
    }

    public void ajouterAcces(int id, String prenom, String login, String password, String statut, int age) throws SQLException {
        String query = "INSERT into Acces VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, id);
        stmt.setString(2, prenom);
        stmt.setString(3, login);
        stmt.setString(4, password);
        stmt.setString(5, statut);
        stmt.setInt(6, age);

        stmt.executeUpdate();
    }

    public void supprimerAcces(int id) throws SQLException {
        String query =  "DELETE FROM acces WHERE id = (?)";
        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public void fermerConnectionDB() throws SQLException {
        connection.close();
    }
}


