package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BaseDAO;
import entite.Aidant;
import entite.Aide;
import entite.Medecin;
import entite.CompteRendu;

/**
 * Servlet implementation class CompteRendu
 */
@WebServlet("/CompteRenduEnvoyer")
public class CompteRenduEnvoyer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteRenduEnvoyer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer identifiantAide = Integer.parseInt(request.getParameter("aideSelect"));
		Aide aide = BaseDAO.getInstance().trouverAide(identifiantAide);
		String commentaire = request.getParameter("comments");
		Date date = new Date();
		Medecin medecin = BaseDAO.getInstance().trouverMedecinParAide(aide);
		HttpSession session = request.getSession();
		Aidant aidant = (Aidant) session.getAttribute("leConnecte");
		try {
			CompteRendu compteRendu = new CompteRendu(commentaire, date, aidant, aide, medecin);
			BaseDAO.getInstance().ajouterCompteRendu(compteRendu);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueilAdmin.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
