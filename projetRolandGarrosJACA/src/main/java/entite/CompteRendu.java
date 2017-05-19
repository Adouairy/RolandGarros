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
@Table(name = "compterendu")
//hello
public class CompteRendu implements Cloneable {
	
	@Id
	@Column(name = "IDCR", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "TEXTE", length = 500, nullable = true)
	private String texte;

	@Column(name = "DATECR", nullable = true)
	private Date dateCr;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDAIDANT", nullable=true)
	private Aidant aidant;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID", nullable=true)
	private Aide aide;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDMEDECIN", nullable=true)
	private Medecin medecin;
	


	

	// constructeurs
	public CompteRendu() {
		
	}


	
	public CompteRendu(String texte, String dateCr, Aidant aidant, Aide aide, Medecin medecin) throws ParseException {
		setTexte(texte);
		setDateCr(dateCr);
		setAidant(aidant);
		setAide(aide);		
		setMedecin(medecin);
	}



	// accesseurs
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTexte() {
		return texte;
	}



	public void setTexte(String texte) {
		this.texte = texte;
	}



	public Date getDateCr() {
		return dateCr;
	}



	public void setDateCr(String dateCr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.dateCr = sdf.parse(dateCr);
	}




	public Medecin getMedecin() {
		return medecin;
	}



	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}



	public Aide getAide() {
		return aide;
	}



	public void setAide(Aide aide) {
		this.aide = aide;
	}



	public Aidant getAidant() {
		return aidant;
	}



	public void setAidant(Aidant aidant) {
		this.aidant = aidant;
	}



	//ToString
	@Override
	public String toString() {
		return "CompteRendu [id=" + id + ", texte=" + texte + ", dateCr=" + dateCr + ", medecin=" + medecin + ", aide="
				+ aide + ", aidant=" + aidant + "]";
	}


	




	
}


	