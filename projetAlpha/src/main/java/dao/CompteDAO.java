package dao;

import java.sql.*;

import modele.Compte;

public class CompteDAO {

	public Compte getByNomEtMdp(String nom, String mdp) throws SQLException {
	    String sql = "SELECT * FROM user WHERE login = ? AND mdp = ?";
	    try (Connection conn = Connexion.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, nom);
	        stmt.setString(2, mdp);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
                return new Compte(rs.getString("login"), rs.getString("mdp"));
            } else {
                return null;
            }

	    }
	}
}

