package dao;

import java.text.ParseException;

import entite.Aidant;
import entite.Aide;
import metier.ServiceVerifMdp;



public class Exe {
	public static void main(String[] args) throws ParseException { 		 
		BaseDAO b = new BaseDAO(); 	
		ServiceVerifMdp s = new ServiceVerifMdp();
		//Aidant a1 = new Aidant("essai@orange.fr","55555 rue de la paix, Nantes", "15/05/1985", "0645454545" , "jaca", "plombier", false, "Tuyau", "Beau");
		//b.ajouterAidant(a1);
		
//		System.out.println(b.verifReferent("essai@orange.fr", "jaca", "aidant"));
//		System.out.println(b.verifReferent("ref@ref.fr", "jaca", "aidant"));
		
		
//		b.ajouterCooperation(b.renvoiAidants().get(1), b.renvoiAides().get(1));
//		b.ajouterCooperation(b.renvoiAidants().get(1), b.renvoiAides().get(1));
//		b.ajouterCooperation(b.renvoiAidants().get(1), b.renvoiAides().get(1));
//		b.ajouterCooperation(b.renvoiAidants().get(1), b.renvoiAides().get(1));
//
//		
		//b.supprimerCooperation(b.renvoiAidants().get(1));
		//System.out.println(b.renvoiCooperations());
		//System.out.println(b.trouverAidant(21));
		//Aide b1 = new Aide("155555 rue de la paix", "14/06/2004", "grave@mamie.fr", "grave", "mamie", "02156598", "jaca", b.renvoiMedecins().get(5));
		//b.ajouterAide(b1);
		
//		b.ajouterAidant("essai@orange.fr","5 rue de la paix, Nantes", "15/05/1985", "0645454545" , "jaca", "plombier", false, "Tuyau", "Beau");
//		System.out.println(b.renvoiMedecins());
		//b.ajouterAide("15 rue de la paix", "14/06/2004", "grave@mamie.fr", "grave", "mamie", "02156598", "jaca", b.renvoiMedecins().get(0));
		
		//b.supprimerAidant(b.renvoiAidants().get(1));

		
		//System.out.println(s.importerAide("pdt@terre.fr"));

		//System.out.println(s.importerAide("pdt@erazerzrzer.fr"));
		
		//System.out.println(b.renvoiAides());
		//System.out.println(b.trouverMedecin(1));
		//System.out.println(b.trouverAidant(1));
		//System.out.println(b.trouverAide(24));
		//b.commit();
//		System.out.println(b.renvoiMedecins()); 
		//b.closeAll();
	}
}