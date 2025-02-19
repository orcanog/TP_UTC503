package fr.esiee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Informations de connexion
        String url = "jdbc:mysql://localhost:3306/nom_de_la_base";
        String user = "root"; // Remplacez par votre utilisateur MySQL
        String password = "root"; // Remplacez par votre mot de passe MySQL

        try {
            // Établir la connexion à la base de données
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion réussie à la base de données !");

            // Créer un objet DAOAcces
            DAOAcces daoAcces = new DAOAcces(connection);

            // Ajouter un accès
            daoAcces.ajouterAcces(1, "Jean", "jdupont", "pass123", "Admin", 30);
            System.out.println("Accès ajouté avec succès.");

            // Lister les accès
            daoAcces.listerAcces();

            // Supprimer un accès
            daoAcces.supprimerAcces(1);
            System.out.println("Accès supprimé avec succès.");

            // Fermer la connexion
            daoAcces.fermerConnectionDB();
            System.out.println("Connexion fermée.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}