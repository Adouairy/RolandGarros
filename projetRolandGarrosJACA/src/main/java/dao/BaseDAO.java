package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entite.Personne;
import entite.Utilisateur;

public class BaseDAO {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	private static BaseDAO instance;

	/**
	 * Le DAO fonctionne en singleton
	 * @return l'instance unique du DAO
	 */
	public static BaseDAO getInstance() {
		if (instance == null) {
			instance = new BaseDAO();
		}
		return instance;
	}

	/**
	 * Constructeur du DAO
	 * Il initialise le contexte de persistance
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

	//public Boolean chercherUtilisateur(Utilisateur utilisateur) {
	//	em.createQuery("select nom from organisateur where ")
	//	em.persist(p);
	//	return p;
	//}
	

}