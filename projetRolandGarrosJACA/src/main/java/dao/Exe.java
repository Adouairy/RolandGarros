package dao;

import java.text.ParseException;
import java.util.Date;



public class Exe {
	public static void main(String[] args) throws ParseException { 		 
		BaseDAO b = new BaseDAO(); 	

//		b.ajouterAidant("essai@orange.fr","5 rue de la paix, Nantes", "15/05/1985", "0645454545" , "jaca", "plombier", false, "Tuyau", "Beau");
		System.out.println(b.renvoiMedecins());
		b.commit();
//		System.out.println(b.renvoiMedecins()); pour commit
		b.closeAll();
	}
}