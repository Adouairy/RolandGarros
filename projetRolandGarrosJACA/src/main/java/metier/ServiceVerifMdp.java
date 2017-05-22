package metier;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import dao.BaseDAO;

public class ServiceVerifMdp {

	private static ServiceVerifMdp instance;

	/**
	 * Le DAO fonctionne en singleton
	 * 
	 * @return l'instance unique du DAO
	 */
	public static ServiceVerifMdp getInstance() {
		if (instance == null) {
			instance = new ServiceVerifMdp();
		}
		return instance;
	}
	public boolean verifMdp(HttpServletRequest request) {
		boolean verif = false;
		String motDePasse = "";
		String motDePasseConf = "";
		motDePasse = request.getParameter("mdpAide");
		motDePasseConf = request.getParameter("confirmAide");
		if (motDePasse.equals(motDePasseConf)) {
			verif = true;
		}
		return verif;
	}

	public boolean notifEnvoyerMail(){
		boolean envoi= false;
		System.out.println("Simulation de la notification d'email!");
		return envoi;
	}

	public boolean delaiInscription(Date dateInscription){
		boolean delai=true;
		//faux si le delai est dépassés
		
		return delai;
	}
}
