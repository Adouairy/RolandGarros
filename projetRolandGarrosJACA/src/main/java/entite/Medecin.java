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
@Table(name = "medecin")
public class Medecin implements Cloneable {
	
	@Id
	@Column(name = "IDMEDECIN", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMedecin;

	@Column(name = "NOM", length = 32, nullable = true)
	private String nom;

	@Column(name = "PRENOM", length = 32, nullable = true)
	private String prenom;

	@Column(name = "MDPMEDECIN", length = 32, nullable = true)
	private String MdpMedecin;

	@Column(name = "MAILMEDECIN", length = 32, nullable = true)
	private String mailMedecin;
	
	@Column(name = "ADRESSEPRO", length = 50, nullable = true)
	private String adressePro;
	
	@Column(name = "TELMEDECIN", length = 50, nullable = true)
	private String telMedecin;
	
	@Column(name = "CONNECTION", length = 50, nullable = true)
	private Integer premiereconnection;
	
	@OneToMany(mappedBy="medecin", cascade={CascadeType.ALL})
	private Set<Aide> aide= new HashSet<Aide>();
	
	@OneToMany(mappedBy="medecin", cascade={CascadeType.ALL})
	private Set<CompteRendu> cr= new HashSet<CompteRendu>();
	
	
	// constructeurs
	public Medecin() {
		
	}


	public Medecin(String nom, String prenom, String mdpMedecin, String mailMedecin,
			String adressePro, String telMedecin, Set<Aide> aide, Set<CompteRendu> cr,Integer premiereconnection) {
		this.nom = nom;
		this.prenom = prenom;
		this.MdpMedecin = mdpMedecin;
		this.mailMedecin = mailMedecin;
		this.adressePro = adressePro;
		this.telMedecin = telMedecin;
		this.aide = aide;
		this.cr = cr;
		this.premiereconnection = premiereconnection;
	}


	// accesseurs


	public Integer getIdMedecin() {
		return idMedecin;
	}


	public void setIdMedecin(Integer idMedecin) {
		this.idMedecin = idMedecin;
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


	public String getMdpMedecin() {
		return MdpMedecin;
	}


	public void setMdpMedecin(String mdpMedecin) {
		MdpMedecin = mdpMedecin;
	}


	public String getMailMedecin() {
		return mailMedecin;
	}


	public void setMailMedecin(String mailMedecin) {
		this.mailMedecin = mailMedecin;
	}


	public String getAdressePro() {
		return adressePro;
	}


	public void setAdressePro(String adressePro) {
		this.adressePro = adressePro;
	}


	public String getTelMedecin() {
		return telMedecin;
	}


	public void setTelMedecin(String telMedecin) {
		this.telMedecin = telMedecin;
	}


	public Set<Aide> getAide() {
		return aide;
	}


	public void setAide(Set<Aide> aide) {
		this.aide = aide;
	}


	public Set<CompteRendu> getCr() {
		return cr;
	}


	public void setCr(Set<CompteRendu> cr) {
		this.cr = cr;
	}


	public Integer getPremiereconnection() {
		return premiereconnection;
	}


	public void setPremiereconnection(Integer premiereconnection) {
		this.premiereconnection = premiereconnection;
	}


	@Override
	public String toString() {
		return "Medecin [idMedecin=" + idMedecin + ", nom=" + nom + ", prenom=" + prenom + ", MdpMedecin=" + MdpMedecin
				+ ", mailMedecin=" + mailMedecin + ", adressePro=" + adressePro + ", telMedecin=" + telMedecin
				+ ", aide=" + aide + ", cr=" + cr + "]";
	}

	
	
	
}


	