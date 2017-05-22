package metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import dao.BaseDAO;
import entite.Aidant;
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
		List<Aidant> listAidant = new ArrayList<Aidant>();
		listAidant=BaseDAO.getInstance().renvoiAidants();
		
		for (int i = 0; i < listAidant.size(); i++) {
			if (listAidant.get(i).getMailAidant().equals(mail)) {
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
		Calendar c = Calendar.getInstance(); 
		c.setTime(dateInscription);
		Calendar cd = new GregorianCalendar(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)); 
		cd.add(GregorianCalendar.DAY_OF_WEEK, +90); 
		Date date = cd.getTime();
		Date now=new Date();
		if(date.compareTo(now)>0){
			delai= true;
		}
		return delai;
	}
	//mots de passe
	public String creationMdp(){
		String mdp="";
		Random rand = new Random();
		for(int i = 0 ; i < 10 ; i++){
		  char c = (char)(rand.nextInt(26) + 97);
		  mdp += c;
		}
		return mdp;
	}
}
