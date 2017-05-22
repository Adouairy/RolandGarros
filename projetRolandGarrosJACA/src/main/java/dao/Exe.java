package dao;

import java.text.ParseException;
import java.util.Date;



public class Exe {
	public static void main(String[] args) throws ParseException { 		 
		BaseDAO b = new BaseDAO(); 	

//		b.ajouterAidant("essai@orange.fr","5 rue de la paix, Nantes", "15/05/1985", "0645454545" , "jaca", "plombier", false, "Tuyau", "Beau");
//		System.out.println(b.renvoiMedecins());
		b.ajouterAide("15 rue de la paix", "14/06/2004", "grave@mamie.fr", "grave", "mamie", "02156598", "jaca", b.renvoiMedecins().get(0));
		b.commit();
//		System.out.println(b.renvoiMedecins()); 
		b.closeAll();
	}
}