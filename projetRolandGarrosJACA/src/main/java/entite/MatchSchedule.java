package entite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name ="MATCHSCHEDULE")
public class MatchSchedule implements Cloneable{

	@Id
	@Column(name = "IDMATCH", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "DATEMATCH", nullable = true)
	private Date dateMatch;

	@Column(name = "DUREE", length = 11, nullable = true)
	private Integer duree;

	@Column(name = "SCORE", nullable = true)
	private String score;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCOURT", nullable=true)
	private Court court;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDTOURNOI", nullable=true)
	private Tournoi tournoi;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDARBITRE", nullable=true)
	private Arbitre arbitre;
	
	private static List<Joueur> listejoueur = new ArrayList<Joueur>();
	
	/**
	 * 
	 */
	public MatchSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static List<Joueur> getListejoueur() {
		return listejoueur;
	}

	public static void setListejoueur(List<Joueur> listejoueur) {
		MatchSchedule.listejoueur = listejoueur;
	}

	/**
	 * @param id
	 * @param dateMatch
	 * @param duree
	 * @param score
	 * @param court
	 * @param tournoi
	 * @param arbitre
	 * @param liste
	 */
	public MatchSchedule(Integer id, Date dateMatch, Integer duree, String score, Court court, Tournoi tournoi,
			Arbitre arbitre) {
		super();
		this.id = id;
		this.dateMatch = dateMatch;
		this.duree = duree;
		this.score = score;
		this.court = court;
		this.tournoi = tournoi;
		this.arbitre = arbitre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public Tournoi getTournoi() {
		return tournoi;
	}

	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}

	public Arbitre getArbitre() {
		return arbitre;
	}

	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
	}


}
