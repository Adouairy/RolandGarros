package entite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@SuppressWarnings("unused")
@Entity
@Table(name = "joueur")
public class Joueur implements Cloneable {
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "NOM", length = 50, nullable = true)
	private String nom;

	@Column(name = "PRENOM", length = 50, nullable = true)
	private String prenom;

	@Column(name = "DDN", nullable = true)
	private Date ddn;

	@Column(name = "SEXE", length = 50, nullable = true)
	private String sexe;
	
	@Column(name = "NATIONALITE", length = 50, nullable = true)
	private String nationalite;
	
	@Column(name = "RANG", length = 11, nullable = true)
	private Integer rang;
	
	@Column(name = "ACTIF", length = 32, nullable = true)
	private Boolean actif;

	// constructeurs
	public Joueur() {
		
	}

	/**
	 * @param sexe
	 * @param ddn
	 * @param rang
	 * @param actif
	 */
	public Joueur(String nom, String prenom, Date ddn, String sexe, String nationalite, Integer rang, Boolean actif) {
		setNom(nom);
		setPrenom(prenom);
		setDdn(ddn);
		setSexe(sexe);
		setNationalite(nationalite);
		setRang(rang);
		setActif(actif);
		
	}
	
	// accesseurs

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getDdn() {
		return ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
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


	