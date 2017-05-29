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
import entite.Aide;
import metier.ServiceVerifMdp;

/**
 * Servlet implementation class EspaceConnecterAideReferent
 */
public class EspaceConnecterAide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EspaceConnecterAide() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean formulaireJuste = true;
		String messageVerifMailRef = null;
		String messageAjoutAidant = null;
		HttpSession session = request.getSession();
		Aide aide = (Aide) session.getAttribute("leConnecte");
		Aidant aidant = new Aidant();
		
		/**
		 * Création de l'aidant si on veut en faire un
		 */
		String mailAidant = request.getParameter("mailAidant");
		String nomAidant = request.getParameter("nomAidant");
		aidant = new Aidant(mailAidant, nomAidant);
		if (nomAidant.isEmpty() && mailAidant.isEmpty()) {
			formulaireJuste = false;
			messageAjoutAidant = "Veuillez ajouter un nom et un mail à votre aidant.";
		} else if (nomAidant.isEmpty() && !mailAidant.isEmpty()) {
			messageAjoutAidant = "Veuillez ajouter un nom à votre aidant.";
			formulaireJuste = false;
		} else if (!nomAidant.isEmpty() && mailAidant.isEmpty()) {
			messageAjoutAidant = "Veuillez ajouter un e-mail à votre aidant.";
			formulaireJuste = false;
		} else { /*------------------- FAIRE LA VERIFICATION DE EMAIL AIDANT !!!! -----------------------------------------*/
			String mdp = ServiceVerifMdp.getInstance().creationMdp();
			aidant.setMdpAidant(mdp);
			System.out.println(aidant.getMdpAidant());
			ServiceVerifMdp.getInstance().notifEnvoyerMail(aidant.getMdpAidant(),aidant.getMailAidant());
		}
		if (formulaireJuste) {
			try {
				BaseDAO.getInstance().ajouterAidant(aidant);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				BaseDAO.getInstance().ajouterCooperation(aidant, aide);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			request.setAttribute("messageAjoutAidant", messageAjoutAidant);
		}
		
		session.setAttribute("aidant", BaseDAO.getInstance().trouverAidantsParAide(aide));

		this.getServletContext().getRequestDispatcher("/WEB-INF/espaceConnecterAide.jsp").forward(request, response);
	}

}
