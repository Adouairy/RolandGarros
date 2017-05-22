package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaseDAO;
import entite.Aidant;
import entite.Aide;
import entite.Medecin;
import metier.ServiceVerifMdp;

/**
 * Servlet implementation class Formulaire
 */
@WebServlet("/Formulaire")
public class Formulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Formulaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		/**
		 * Création du référent (en passant par sa vérification d'e-mail (existe
		 * ou non), ajout du mdp par défaut)
		 */
		try {
			Aidant ref = new Aidant(request.getParameter("mailRef"), request.getParameter("adresseRef"),
					sdf.parse(request.getParameter("ddnRef")), true, request.getParameter("nomRef"),
					request.getParameter("prenomRef"), 1);
			String mdp = ServiceVerifMdp.getInstance().creationMdp();
			ref.setMdpAidant(mdp);
			BaseDAO.getInstance().ajouterAidant(ref);
		} catch (ParseException e) {
			System.out.println("Erreur referent");
		}

		/**
		 * Création de l'aidant (en passant par sa vérification d'e-mail (existe
		 * ou non))
		 */
		try {
			String mailAidant = request.getParameter("mailAidant");
			String nomAidant = request.getParameter("nomAidant");
			if (nomAidant.isEmpty() && mailAidant.isEmpty()) {
				System.out.println("nom et mail vide");
			} else if (nomAidant.isEmpty() && !mailAidant.isEmpty()) {
				System.out.println("manque le nom");
			} else if (!nomAidant.isEmpty() && mailAidant.isEmpty()) {
				System.out.println("manque le mail");
			} else {
				Aidant aide = new Aidant(request.getParameter("mailAidant"), request.getParameter("nomAidant"));
				ServiceVerifMdp.getInstance().verifMailAidant(request);
				BaseDAO.getInstance().ajouterAidant(aide);
			}

		} catch (ParseException e) {
			System.out.println("Erreur aidant");
		}

		/**
		 * Création de l'aide
		 */
		try {
			Medecin med = new Medecin();
			Aide util = new Aide(request.getParameter("adresseAide"), request.getParameter("ddnAide"),
					request.getParameter("mailAide"), request.getParameter("nomAide"),
					request.getParameter("prenomAide"), request.getParameter("telAide"),
					request.getParameter("mdpAide"), med);
		} catch (ParseException e) {
			System.out.println("Erreur aide");
		}

		if (ServiceVerifMdp.getInstance().verifMdp(request)) {
			this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
