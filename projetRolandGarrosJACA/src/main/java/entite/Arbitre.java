package entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "arbitre")
public class Arbitre implements Cloneable {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "NOM", length = 50, nullable = true)
	private String nom;

	@Column(name = "PRENOM", length = 50, nullable = true)
	private String prenom;

	@Column(name = "NATIONALITE", length = 25, nullable = true)
	private String nationalite;

	@Column(name = "POSTE", length = 25, nullable = true)
	private String poste;

	// constructeurs

	public Arbitre() {
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param nationalite
	 * @param poste
	 */
	public Arbitre(String nom, String prenom, String nationalite, String poste) {
		setNom(nom);
		setPrenom(prenom);
		setNationalite(nationalite);
		setPoste(poste);
	}
	
	//To String
	@Override
	public String toString() {
		return "Arbitre [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nationalite=" + nationalite + ", poste="
				+ poste + "]";
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
