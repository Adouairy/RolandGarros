package entite;

import java.util.Date;

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
	
	@Column(name = "RANG", length = 11, nullable = true)
	private Integer rang;
	
	@Column(name = "ACTIF", length = 32, nullable = true)
	private Boolean actif=true;


}
