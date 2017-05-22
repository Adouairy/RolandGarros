package dao;

import java.text.ParseException;

import entite.Aidant;
import entite.Aide;



public class Exe {
	public static void main(String[] args) throws ParseException { 		 
		BaseDAO b = new BaseDAO(); 	

		//Aidant a1 = new Aidant("essai@orange.fr","55555 rue de la paix, Nantes", "15/05/1985", "0645454545" , "jaca", "plombier", false, "Tuyau", "Beau");
		//b.ajouterAidant(a1);
		
		//Aide b1 = new Aide("155555 rue de la paix", "14/06/2004", "grave@mamie.fr", "grave", "mamie", "02156598", "jaca", b.renvoiMedecins().get(5));
		//b.ajouterAide(b1);
		
//		b.ajouterAidant("essai@orange.fr","5 rue de la paix, Nantes", "15/05/1985", "0645454545" , "jaca", "plombier", false, "Tuyau", "Beau");
//		System.out.println(b.renvoiMedecins());
		//b.ajouterAide("15 rue de la paix", "14/06/2004", "grave@mamie.fr", "grave", "mamie", "02156598", "jaca", b.renvoiMedecins().get(0));
		
		b.supprimerAidant(b.renvoiAidants().get(1));

		//System.out.println(b.renvoiAides());
	//erz	
		b.commit();
//		System.out.println(b.renvoiMedecins()); 
		b.closeAll();
	}
}