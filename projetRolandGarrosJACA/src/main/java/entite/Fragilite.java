package entite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@SuppressWarnings("unused")
@Entity
@Table(name = "fragilite")
public class Fragilite implements Cloneable {
	
	@Id
	@Column(name = "IDFRAGILITE", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "NOM", length = 50, nullable = true)
	private String nom;

	@OneToMany(mappedBy="fragilite", cascade={CascadeType.ALL})
	private Set<DetailsFragilite> coop= new HashSet<DetailsFragilite>();
	

	// constructeurs
	public Fragilite() {
		
	}
 
	
	public Fragilite(String nom) {
		this.nom = nom;
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


	//ToString
	@Override
	public String toString() {
		return "Fragilite [id=" + id + ", nom=" + nom + "]";
	}


	
}


		