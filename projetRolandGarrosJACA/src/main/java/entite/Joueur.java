package entite;

import java.util.Date;

public class Joueur extends Personne {

	protected String sexe;
	protected Date ddn;
	protected Integer rang;
	protected Boolean actif = true;

	// Constructeurs

	/**
	 * @param sexe
	 * @param ddn
	 * @param rang
	 * @param actif
	 */
	public Joueur(String nom, String prenom, String nationalite, String sexe, Date ddn, Integer rang, Boolean actif) {
		super(nom, prenom, nationalite);
		this.sexe = sexe;
		this.ddn = ddn;
		this.rang = rang;
		this.actif = actif;
	}

	public Joueur() {
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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Date getDdn() {
		return ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	public Integer getRang() {
		return rang;
	}

	public void setRang(Integer rang) {
		this.rang = rang;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

}
