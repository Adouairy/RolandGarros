package entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "tournoi")
public class Tournoi implements Cloneable  {
	
	@Id
	@Column(name = "IDTOURNOI", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "NOM", length = 50, nullable = true)
	private String nom;

	@Column(name = "TYPE", length = 50, nullable = true)
	private Integer type;

	@OneToMany(mappedBy="tournoi", cascade={CascadeType.ALL})
	private Set<MatchSchedule> matchSchedule3= new HashSet<MatchSchedule>();
	

	
	
	//constructeurs
	/**
	 * @param nom
	 * @param type
	 */
	public Tournoi(String nom, Integer type) {
	
		setNom(nom);
		setType(type);
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	//ToString
	@Override
	public String toString() {
		return "Tournoi [id=" + id + ", nom=" + nom + ", type=" + type + "]";
	}
	

	
	
	
}
