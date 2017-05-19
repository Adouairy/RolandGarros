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
@Table(name = "cooperation")
public class Cooperation implements Cloneable {

	@Id
	@Column(name = "IDCOOPERATION", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCooperation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDAIDANT", nullable = true)
	private Aidant aidant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID", nullable = true)
	private Aide aide;

	// constructeurs
	public Cooperation() {

	}

	public Cooperation(Aidant aidant, Aide aide) {
		this.aidant = aidant;
		this.aide = aide;
	}

	// accesseurs

	public Integer getIdCooperation() {
		return idCooperation;
	}

	public void setIdCooperation(Integer idCooperation) {
		this.idCooperation = idCooperation;
	}

	public Aidant getAidant() {
		return aidant;
	}

	public void setAidant(Aidant aidant) {
		this.aidant = aidant;
	}

	public Aide getAide() {
		return aide;
	}

	public void setAide(Aide aide) {
		this.aide = aide;
	}

	// ToString
	@Override
	public String toString() {
		return "Cooperation [idCooperation=" + idCooperation + ", aidant=" + aidant + ", aide=" + aide + "]";
	}

}
	