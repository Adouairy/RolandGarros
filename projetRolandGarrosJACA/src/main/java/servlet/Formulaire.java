package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entite.Aidant;
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
		try {
			Aidant ref = new Aidant(request.getParameter("mailRef"), request.getParameter("adresseRef"),
					sdf.parse(request.getParameter("ddnRef")), true, request.getParameter("nomRef"),
					request.getParameter("prenomRef"), 1);
			System.out.println(ref);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("pas dans le try mais dans le catch");
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
