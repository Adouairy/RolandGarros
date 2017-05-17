package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Query;

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
	public Boolean verifConnection(Organisateur organisateur) {
		Boolean resultat = true;
		if (em.createQuery("select nom from Organisateur where nom = '" + organisateur.getNom() + "'"
				+ "AND mdp = MD5('" + organisateur.getMdp() + "')").getResultList().isEmpty()) {
			resultat = false;

		}
		return resultat;
	}

}