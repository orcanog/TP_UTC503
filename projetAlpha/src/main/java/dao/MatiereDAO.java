package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modele.Matiere;

public class MatiereDAO {

    public List<Matiere> getAll() throws SQLException {
        List<Matiere> matieres = new ArrayList<>();
        String sql = "SELECT * FROM matiere";

        try (Connection conn = Connexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                matieres.add(new Matiere(
                	rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getInt("nbheure")
                ));
            }
        }

        return matieres;
    }

    public Matiere getById(int id) throws SQLException {
        String sql = "SELECT * FROM matiere WHERE id = ?";
        try (Connection conn = Connexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Matiere(
                	rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getInt("nbheure")
                );
            } else {
                return null;
            }
        }
    }

    public void insert(String nom, int heure) throws SQLException {
        String sql = "INSERT INTO matiere (nom, nbheure) VALUES (?, ?)";
        try (Connection conn = Connexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, nom);
            stmt.setInt(2, heure);
            stmt.executeUpdate();
        }
    }

    public void update(String nom, int heure, int id) throws SQLException {
        String sql = "UPDATE matiere SET nom = ?, nbheure = ? WHERE id = ?";
        try (Connection conn = Connexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            stmt.setInt(2, heure);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }
}