package dao;

import entite.Organisateur;

public class Exe {
	public static void main(String[] args) { 		 
		BaseDAO b = new BaseDAO(); 		
		Organisateur o = new Organisateur("Garros", true, "jaca"); 	
		 
		System.out.println(b.verifConnection(o) );

	}
}