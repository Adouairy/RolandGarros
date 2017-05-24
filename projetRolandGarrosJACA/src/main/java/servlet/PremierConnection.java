package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entite.Aidant;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* Création ou récupération de la session */
		HttpSession session = request.getSession();
		
		/* Récupération de l'objet depuis la session */
		Aidant aidantConnecte= (Aidant) session.getAttribute( "leConnecte" );
		System.out.println(aidantConnecte);
		this.getServletContext().getRequestDispatcher("/WEB-INF/premierConnection.jsp").forward(request,response);

	}


}
