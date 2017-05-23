package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaseDAO;
import entite.Aidant;
import metier.ServiceVerifMdp;

public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	BaseDAO dao = BaseDAO.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
         * fonction qui teste le temps de presence d'un aidant sans confirmation dans 
         * la base de donnée
         */
        List<Aidant> listeAidant =new ArrayList<Aidant>();
        listeAidant = BaseDAO.getInstance().renvoiAidants();
        Date inscription = new Date();
        boolean delaiDepasse = true;
        for (int i = 0; i < listeAidant.size(); i++) {
            inscription = listeAidant.get(i).getDateInscription();
            if(inscription!=null){
            delaiDepasse=ServiceVerifMdp.getInstance().delaiInscription(inscription);
            System.out.println(listeAidant.get(i));
            }
            if(!delaiDepasse){
            	System.out.println(listeAidant.get(i));
                BaseDAO.getInstance().supprimerAidant(listeAidant.get(i));
            }
        }
        
        /**
         * Vérification de la connection
         */
        String table= request.getParameter("select");
		String email= request.getParameter("email");
		String mdp= request.getParameter("mdpIdentifiant");
		String message= null;
		String MessageErreur= null;
		//booleen
		System.out.println(email);
		Boolean estDansLaBase=dao.verifConnection(email,mdp,table);
//		Boolean estRef = dao.;
		if (estDansLaBase){
			if (table.equals("aidant")) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/accueilAdmin.jsp").forward(request, response);
			} else if (table.equals("aide")) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/espaceConnecterAideReferent.jsp").forward(request, response);
			} else if (table.equals("aidant") /*&& estRef*/) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/espaceConnecterAideReferent.jsp").forward(request, response);
			}
		}
		else{
			MessageErreur="Erreur";
			message = "Connection échouée, veuillez réessayer";
			request.setAttribute("MessageErreur", MessageErreur);
			request.setAttribute("message", message);
			this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		}
		
	}
}

