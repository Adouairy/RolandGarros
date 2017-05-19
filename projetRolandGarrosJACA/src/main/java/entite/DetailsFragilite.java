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
@Table(name = "detailsfragilite")
public class DetailsFragilite implements Cloneable {
	
	@Id
	@Column(name = "IDDETAILSFRAGILITE", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idDetailsFragilite;

	@Column(name = "GRAVITE", length = 32, nullable = true)
	private String gravite;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDFRAGILITE", nullable=true)
	private Fragilite fragilite;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID", nullable=true)
	private Aide aide;

	// constructeurs
	public DetailsFragilite() {
		
	}
	
	public DetailsFragilite(String gravite) {
		this.gravite = gravite;
	}



	// accesseurs

	public Integer getIdDetailsFragilite() {
		return idDetailsFragilite;
	}

	public void setIdDetailsFragilite(Integer idDetailsFragilite) {
		this.idDetailsFragilite = idDetailsFragilite;
	}

	public String getGravite() {
		return gravite;
	}

	public void setGravite(String gravite) {
		this.gravite = gravite;
	}

	//ToString
	@Override
	public String toString() {
		return "DetailFragilite [idDetailsFragilite=" + idDetailsFragilite + ", gravite=" + gravite + "]";
	}

	
	
	
}


	