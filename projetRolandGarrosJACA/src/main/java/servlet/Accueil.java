package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaseDAO;

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
		String table= request.getParameter("select");
		String email= request.getParameter("email");
		String mdp= request.getParameter("mdpIdentifiant");
		//booleen
		System.out.println(email);
		Boolean estDansLaBase=dao.verifConnection(email,mdp,table);
		if (estDansLaBase){
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueilAdmin.jsp").forward(request, response);
			
		}
		else{
			this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		}
		
	}
}

