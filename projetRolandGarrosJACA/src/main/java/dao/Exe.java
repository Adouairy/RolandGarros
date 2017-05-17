package dao;

import java.text.ParseException;

import entite.Joueur;
import entite.Organisateur;

public class Exe {
	public static void main(String[] args) throws ParseException { 		 
		BaseDAO b = new BaseDAO(); 		
		Organisateur o = new Organisateur("Garros", "Roland", "jaca"); 	
		 
		System.out.println(b.verifConnection(o) );

		b.ajouterJoueur("Guillois","Antoine","12/05/1988","m", "français", 5);
		//System.out.println(b.chercherJoueur("Guillois", "Antoine"));
		b.closeAll();
	}
}