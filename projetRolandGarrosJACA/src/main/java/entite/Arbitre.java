package entite;

public class Arbitre extends Personne {

	protected String poste;

	// constructeurs

	/**
	 * @param nom
	 * @param prenom
	 * @param nationalite
	 */
	public Arbitre(String nom, String prenom, String nationalite, String poste) {
		super(nom, prenom, nationalite);
		this.poste = poste;
	}

	public Arbitre() {
		super();
	}

	// accesseurs
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

}
