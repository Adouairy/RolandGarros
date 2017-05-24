package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		Boolean formulaireJuste = true;
		String messageVerifMailRef = null;
		String messageAjoutAidant = null;
		String messageVerifMdp = null;
		String messageMailAide = null;
		String messageValidAide = null;

		Aidant aidant = new Aidant();
		Aide aide = new Aide();
		Aidant ref = new Aidant();
		/**
		 * Création du référent (en passant par sa vérification d'e-mail (existe
		 * ou non), ajout du mdp par défaut)
		 */
		try {
			String mailRef = request.getParameter("mailRef");
			String adresseRef = request.getParameter("adresseRef");
			Date ddnRef = sdf.parse(request.getParameter("ddnRef"));
			String nomRef = request.getParameter("nomRef");
			String prenomRef = request.getParameter("prenomRef");
			Boolean mailCorrect = ServiceVerifMdp.getInstance().verifMailRef(request);
			ref = new Aidant(mailRef, adresseRef, ddnRef, true, nomRef, prenomRef, 1);
			if (!mailCorrect) {
				String mdp = ServiceVerifMdp.getInstance().creationMdp();
				ref.setMdpAidant(mdp);
				ServiceVerifMdp.getInstance().notifEnvoyerMail(ref.getMdpAidant(),ref.getMailAidant());
			} else {
				messageVerifMailRef = "Cette adresse mail est déjà utilisée";
				formulaireJuste = false;
			}
		} catch (ParseException e) {
			System.out.println("Erreur referent");
		}

		/**
		 * Création de l'aidant si on veut en faire un
		 */
		String mailAidant = request.getParameter("mailAidant");
		String nomAidant = request.getParameter("nomAidant");
		aidant = new Aidant(mailAidant, nomAidant);
		if (nomAidant.isEmpty() && mailAidant.isEmpty()) {
	
		} else if (nomAidant.isEmpty() && !mailAidant.isEmpty()) {
			messageAjoutAidant = "Veuillez ajouter un nom à votre aidant.";
			formulaireJuste = false;
		} else if (!nomAidant.isEmpty() && mailAidant.isEmpty()) {
			messageAjoutAidant = "Veuillez ajouter un e-mail à votre aidant.";
			formulaireJuste = false;
		} else { /*------------------- FAIRE LA VERIFICATION DE EMAIL AIDANT !!!! -----------------------------------------*/
			//ServiceVerifMdp.getInstance().verifMailAidant(request);
			System.out.println("yesssssssssssssssssssssssssssssssssssssssssssssssss");
			String mdp = ServiceVerifMdp.getInstance().creationMdp();
			aidant.setMdpAidant(mdp);
			System.out.println(aidant.getMdpAidant());
			ServiceVerifMdp.getInstance().notifEnvoyerMail(aidant.getMdpAidant(),aidant.getMailAidant());
		}

		/**
		 * Création de l'aide
		 */
		try {
			Medecin med = new Medecin();
			Integer identifiantMed = Integer.parseInt(request.getParameter("database1"));
			med = BaseDAO.getInstance().trouverMedecin(identifiantMed);
			Integer a = 0;
			String adresseAide = request.getParameter("adresseAide");
			String ddnAide = request.getParameter("ddnAide");
			String mailAide = request.getParameter("mailAide");
			String nomAide = request.getParameter("nomAide");
			String prenomAide = request.getParameter("prenomAide");
			String telAide = request.getParameter("telAide");
			String mdpAide = request.getParameter("mdpAide");
			Boolean verifMdp = ServiceVerifMdp.getInstance().verifMdp(request);
			Boolean verifMail = ServiceVerifMdp.getInstance().verifMailAide(request);
			aide = new Aide(adresseAide, ddnAide, mailAide, nomAide, prenomAide, telAide, mdpAide, med);
			if (verifMdp) {
				a++;
			} else {
				messageVerifMdp = "Les mots de passes doivent être identiques.";
				formulaireJuste = false;
			}
			if (!verifMail) {
				a++;

			} else {
				messageMailAide = "Cette adresse mail est déjà utilisée.";
				formulaireJuste = false;
			}
			if (a == 2) {

			} else {
				messageValidAide = "L'aidé n'a pas pu être inscrit.";
				formulaireJuste = false;
			}

		} catch (ParseException e) {
			System.out.println("Erreur aide");
		}

		if (formulaireJuste) {
			try {
				System.out.println("envoyer ref");
				BaseDAO.getInstance().ajouterAidant(ref);
				System.out.println(ref);
				System.out.println("envoyer ref");

				BaseDAO.getInstance().ajouterAide(aide);
				BaseDAO.getInstance().ajouterCooperation(ref, aide);
				if(!aidant.getMailAidant().isEmpty()){
					BaseDAO.getInstance().ajouterAidant(aidant);
					BaseDAO.getInstance().ajouterCooperation(aidant, aide);
				}								

			} catch (Exception e) {
				System.out.println("exception");
			}
			this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		} else {
			List<Medecin> listMedecin = new ArrayList<Medecin>();
			listMedecin = BaseDAO.getInstance().renvoiMedecins();
			request.setAttribute("aide", aide);
			request.setAttribute("ref", ref);
			request.setAttribute("aidant", aidant);
			request.setAttribute("messageVerifMailRef", messageVerifMailRef);
			request.setAttribute("messageAjoutAidant", messageAjoutAidant);
			request.setAttribute("messageVerifMdp", messageVerifMdp);
			request.setAttribute("messageMailAide", messageMailAide);
			request.setAttribute("messageValidAide", messageValidAide);
			request.setAttribute("listMedecin", listMedecin);
			this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
		}
		// BaseDAO.getInstance().closeAll();
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
