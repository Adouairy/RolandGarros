package entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "organisateur")
public class Organisateur implements Cloneable{
	
	
	@Id
	@Column(name = "IDUTILISATEUR", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "NOM", length = 50, nullable = true)
	private String nom;

	@Column(name = "PRENOM", length = 50, nullable = true)
	private Boolean disponibilite;

	@Column(name = "MDP", length = 50, nullable = true)
	private String mdp;
 
	//constructeurs

	public Organisateur() {

	}
	

	public Organisateur(String nom, Boolean disponibilite, String mdp) {
		setNom(nom);
		setDisponibilite(disponibilite);
		setMdp(mdp);
	}



	//accesseurs
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

	public Boolean getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(Boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	
	//ToString
	@Override
	public String toString() {
		return "Organisateur [id=" + id + ", nom=" + nom + ", disponibilite=" + disponibilite + ", mdp=" + mdp + "]";
	}
	
}
