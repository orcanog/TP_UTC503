package controlleur;

import java.io.IOException;
import java.sql.SQLException;

import dao.CompteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Compte;

@WebServlet("/connexion")
public class ConnexionCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("login");
        String mdp = request.getParameter("mdp");

        CompteDAO dao = new CompteDAO();
        try {
            Compte compte = dao.getByNomEtMdp(nom, mdp);
            if (compte != null) {
                request.getSession().setAttribute("utilisateur", compte);
                response.sendRedirect(request.getContextPath() + "/matiere?action=accueil");
            } else {
                request.setAttribute("erreur", "Mauvaise connexion");
                request.getRequestDispatcher("/WEB-INF/vue/Connexion.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
		
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/vue/Connexion.jsp").forward(request, response);
    }
}