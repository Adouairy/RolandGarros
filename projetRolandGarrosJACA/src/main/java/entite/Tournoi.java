package entite;

public class Tournoi {

	protected String nom;
	protected String type;
	
	//constructeurs
	/**
	 * @param nom
	 * @param type
	 */
	public Tournoi(String nom, String type) {
		super();
		this.nom = nom;
		this.type = type;
	}
	
	public Tournoi() {
		super();
	}

	//accesseurs
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	
	
}
