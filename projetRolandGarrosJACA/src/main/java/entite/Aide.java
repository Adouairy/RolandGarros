package entite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Table(name = "aide")
public class Aide implements Cloneable {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ADRESSE", length = 50, nullable = true)
	private String adresse;

	@Column(name = "DDN", nullable = true)
	private Date ddn;

	@Column(name = "MAIL", nullable = true)
	private String mail;

	@Column(name = "NOM", length = 32, nullable = true)
	private String nom;

	@Column(name = "PRENOM", length = 32, nullable = true)
	private String prenom;

	@Column(name = "TEL", length = 50, nullable = true)
	private String tel;

	@Column(name = "MDPAIDE", length = 32, nullable = true)
	private String mdpAide;

	@Column(name = "DATEINSCRIPTION", nullable = true)
	private Date dateInscription = new Date();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDMEDECIN", nullable = true)
	private Medecin medecin;

	@OneToMany(mappedBy = "aide", cascade = { CascadeType.ALL })
	private Set<CompteRendu> cr = new HashSet<CompteRendu>();

	@OneToMany(mappedBy = "aide", cascade = { CascadeType.ALL })
	private Set<Cooperation> coop = new HashSet<Cooperation>();

	// constructeurs
	public Aide() {

	}
	
	public Aide(String adresse, Date ddn, String mail, String nom, String prenom, String tel, String mdpAide,
			Medecin medecin) {
		super();
		this.adresse = adresse;
		this.ddn = ddn;
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mdpAide = mdpAide;
		this.medecin = medecin;
	}


/**
 * Constructeur pour le formulaire
 * @param adresse
 * @param ddn
 * @param mail
 * @param nom
 * @param prenom
 * @param tel
 * @param mdpAide
 * @param medecin
 * @throws ParseException
 */
	public Aide(String adresse, String ddn, String mail, String nom, String prenom, String tel, String mdpAide,
			Medecin medecin) throws ParseException {
		setAdresse(adresse);
		setDdn(ddn);
		setMail(mail);
		setNom(nom);
		setPrenom(prenom);
		setTel(tel);
		setMdpAide(mdpAide);
		setMedecin(medecin);

	}

	// accesseurs
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDdn() {
		return ddn;
	}

	public void setDdn(String ddn) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.ddn = sdf.parse(ddn);
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMdpAide() {
		return mdpAide;
	}

	public void setMdpAide(String mdpAide) {
		this.mdpAide = mdpAide;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	// ToString
	@Override
	public String toString() {
		return "Aide [id=" + id + ", adresse=" + adresse + ", ddn=" + ddn + ", mail=" + mail + ", nom=" + nom
				+ ", prenom=" + prenom + ", tel=" + tel + ", mdpAide=" + mdpAide + "   ]";
	}
// , id_medecin=" + medecin.getIdMedecin()
}
