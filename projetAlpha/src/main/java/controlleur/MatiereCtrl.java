package controlleur;

import java.io.IOException;
import java.sql.SQLException;

import dao.MatiereDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/matiere")
public class MatiereCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String nom = request.getParameter("nom");
		int heure = Integer.parseInt(request.getParameter("heure"));
		MatiereDAO matiereDAO = new MatiereDAO();
		
		switch (action) {
		case "ajout":
			try {
				matiereDAO.insert(nom, heure);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath() + "/matiere?action=accueil");
			break;
			
		case "modifier":
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				matiereDAO.update(nom, heure, id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath() + "/matiere?action=accueil");
			break;
			
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Action inconnue");
			break;
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		MatiereDAO matiereDAO = new MatiereDAO();
		
		switch (action) {
		case "ajout":
			request.getRequestDispatcher("/WEB-INF/vue/AjoutMatiere.jsp").forward(request, response);
			break;
			
		case "modifier":
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				if (matiereDAO.getById(id) != null) {
					request.setAttribute("id", id);
					request.getRequestDispatcher("/WEB-INF/vue/ModifierMatiere.jsp").forward(request, response);
				} else {
					response.sendError(HttpServletResponse.SC_NOT_FOUND, "ID inexistant");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    break;
		    
		case "accueil":
			try {
				request.setAttribute("matieres", matiereDAO.getAll());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/vue/Matiere.jsp").forward(request, response);
			break;
			
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Action inconnue");
			break;
		}
	}
}