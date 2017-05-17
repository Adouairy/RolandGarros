package dao;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entite.Joueur;
import entite.Organisateur;

//singleton ----------------------------------------
public class BaseDAO {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	private static BaseDAO instance;

	/**
	 * Le DAO fonctionne en singleton
	 * 
	 * @return l'instance unique du DAO
	 */
	public static BaseDAO getInstance() {
		if (instance == null) {
			instance = new BaseDAO();
		}
		return instance;
	}

	// -------------------------------------------------
	/**
	 * Constructeur du DAO Il initialise le contexte de persistance
	 */
	public BaseDAO() {
		emf = Persistence.createEntityManagerFactory("jpa");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}

	/**
	 * Synchronise le context de persistance avec la base de donnée.
	 * En fait un commit est effectué et une nouvelle transaction débutée
	 */
	public void commit(){
		tx.commit();
		tx.begin();
	}
	
	/**
	 * Ferme la factory d'entity manager et l'entity manager
	 */
	public void closeAll() {
		em.close();
		emf.close();
	}

	/**
	 * La fonction renvoie true si la personne a bien entré un nom et un mot de
	 * passe valides
	 * 
	 * @return true si c'est ok et false si erreur de connection
	 */
	public Boolean verifConnection(Organisateur o) {
		Boolean resultat = true;
		if (em.createQuery("select o from Organisateur o where nom = '" + o.getNom() + "'"
				+ "AND mdp = MD5('" + o.getMdp() + "')").getResultList().isEmpty()) {
			resultat = false;
		}
		return resultat;
	}
	
	/**
	 * Ajoute un joueur dans la base de données
	 */
	public void ajouterJoueur(String nom, String prenom, String ddn, String sexe, String nationalite, Integer rang) throws ParseException {
		Joueur joueur = new Joueur(nom, prenom, ddn,sexe, nationalite, rang);
		em.persist(joueur);
	}
	
//	public Joueur chercherJoueur(String nom, String prenom){
//		Query query =  (Query) em.createQuery("select j from Joueur j where nom = '" + nom + "'"
//				+ "AND prenom = '" + prenom + "')").getResultList();
//	}

}