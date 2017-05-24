package servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BaseDAO;
import entite.Aidant;
import metier.ServiceVerifMdp;

/**
 * Servlet implementation class PremierConnection
 */

public class PremierConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PremierConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* Création ou récupération de la session */
		HttpSession session = request.getSession();

		/* Récupération de l'objet depuis la session */
		Aidant aidantConnecte = (Aidant) session.getAttribute("leConnecte");
		Boolean verifMdp = ServiceVerifMdp.getInstance().verifMdpAidant(request);

		aidantConnecte.setPrenomAidant(request.getParameter("iPrenomAidant"));
		aidantConnecte.setAdresseAidant(request.getParameter("iAdresseAidant"));
		try {
			aidantConnecte.setDdnAidant(request.getParameter("iDdnAidant"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aidantConnecte.setTelAidant(request.getParameter("iTelAidant"));
		aidantConnecte.setType(request.getParameter("catAidant"));
		aidantConnecte.setPremiereconnection(0);
		aidantConnecte.setMdpAidant(request.getParameter("iMdpAidant"));
		if (verifMdp) {
			BaseDAO.getInstance().UpdateAidant(aidantConnecte);
			if (aidantConnecte.getReferent()) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/espaceConnecterReferent.jsp").forward(request, response);
			} else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/accueilAdmin.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("aidantCo", aidantConnecte);
			this.getServletContext().getRequestDispatcher("/WEB-INF/premierConnection.jsp").forward(request, response);
		}
	}

}
