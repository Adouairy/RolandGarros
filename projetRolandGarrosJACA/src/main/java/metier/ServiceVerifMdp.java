package metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.BaseDAO;
import entite.Aide;

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

	public boolean verifMailAide(HttpServletRequest request) {
		boolean verif = false;
		String mail = "";
		mail = request.getParameter("mailAide");
		List<Aide> listAide = new ArrayList<Aide>();
		listAide=BaseDAO.getInstance().renvoiAides();
		
		for (int i = 0; i < listAide.size(); i++) {
			if (listAide.get(i).getMail().equals(mail)) {
				verif = true;
			}
		}
	
		return verif;
	}
	
	public boolean verifMailAidant(HttpServletRequest request) {
		boolean verif = false;
		String mail = "";
		mail = request.getParameter("mailAide");
		List<Aide> listAide = new ArrayList<Aide>();
		listAide=BaseDAO.getInstance().renvoiAidants();
		
		for (int i = 0; i < listAide.size(); i++) {
			if (listAide.get(i).getMail().equals(mail)) {
				verif = true;
			}
		}
	
		return verif;
	}
	
	public boolean notifEnvoyerMail(){
		boolean envoi= false;
		System.out.println("Simulation de la notification d'email!");
		return envoi;
	}

	public boolean delaiInscription(Date dateInscription){
		boolean delai=false;
		//faux si le delai est dépassés
		Calendar cd = new GregorianCalendar(dateInscription.getYear(),dateInscription.getMonth(),dateInscription.getDay()); 
		cd.add(GregorianCalendar.MONTH, +3); 
		Date date = cd.getTime();
		Date now=new Date();
		if(now.compareTo(date)>0){
			delai= true;
		}
		return delai;
	}
}
