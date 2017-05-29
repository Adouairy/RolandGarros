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
 * Servlet implementation class EspaceConnecterReferent
 */
@WebServlet("/EspaceConnecterReferent")
public class EspaceConnecterReferent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EspaceConnecterReferent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean formulaireJuste = true;
		String messageVerifMailRef = null;
		String messageAjoutAidant = null;
		HttpSession session = request.getSession();
		Aidant aidant = (Aidant) session.getAttribute("leConnecte");
		Aide aide = new Aide();
		aide=BaseDAO.getInstance().trouverAidesParAidant(aidant).get(0);
		Aidant aidantAjout = new Aidant();

		/**
		 * Création de l'aidant si on veut en faire un
		 */
		String mailAidant = request.getParameter("mailAidant");
		String nomAidant = request.getParameter("nomAidant");
		aidantAjout = new Aidant(mailAidant, nomAidant);
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
			aidantAjout.setMdpAidant(mdp);
			System.out.println(aidantAjout.getMdpAidant());
			ServiceVerifMdp.getInstance().notifEnvoyerMail(aidantAjout.getMdpAidant(),aidantAjout.getMailAidant());
		}
		if (formulaireJuste) {
			try {
				BaseDAO.getInstance().ajouterAidant(aidantAjout);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				BaseDAO.getInstance().ajouterCooperation(aidantAjout, aide);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			request.setAttribute("messageAjoutAidant", messageAjoutAidant);
		}
		
		session.setAttribute("aidant", BaseDAO.getInstance().trouverAidantsParAide(aide));

		this.getServletContext().getRequestDispatcher("/WEB-INF/espaceConnecterReferent.jsp").forward(request, response);

	}

}
