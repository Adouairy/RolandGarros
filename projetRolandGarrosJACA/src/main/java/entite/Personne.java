package entite;

public abstract class Personne {
	
protected String nom;
protected String prenom;
protected String nationalite;



//Constructeurs
/**
 * @param nom
 * @param prenom
 * @param nationalite
 */
public Personne(String nom, String prenom, String nationalite) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.nationalite = nationalite;
}

public Personne() {
	super();
	// TODO Auto-generated constructor stub
}



}
