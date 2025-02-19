package fr.esiee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDAOFactory implements DAOFactory {
    private Connection connection;

    public DatabaseDAOFactory() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException("Erreur de connexion à la base de données", e);
        }
    }

    @Override
    public StudentDAO getStudentDAO() {
        return new StudentDAOImpl(connection);
    }
}
