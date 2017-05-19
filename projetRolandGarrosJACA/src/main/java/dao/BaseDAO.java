package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entite.Aidant;
import entite.Medecin;


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
	//pour rien

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
	 * Synchronise le context de persistance avec la base de donnee.
	 * En fait un commit est effectue et une nouvelle transaction d�but�e
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
	 * La fonction renvoie true si la personne a bien entre un nom et un mot de
	 * passe valides
	 * 
	 * @return true si c'est ok et false si erreur de connection
	 */
	public Boolean verifConnection(String mail, String mdp, String nomTable) {
		Boolean resultat = true;
		if (nomTable.equals("aidant")) {
			if (em.createQuery("select nomAidant from Aidant where mailAidant = '" + mail + "'"
					+ " AND mdpAidant = MD5('" + mdp + "')").getResultList().isEmpty()) {
				resultat = false;
			} else {
				resultat = true;
			}	
		} 
		else if (nomTable.equals("aide")) {
			if (em.createQuery("select nom from Aide where mail = '" + mail + "'"
					+ "AND mdp = MD5('" + mdp + "')").getResultList().isEmpty()) {
				resultat = false;
			} else {
				resultat = true;
			}	
		}
		else {
			if (em.createQuery("select mailMedecin from Medecin where mailMedecin = '" + mail + "'"
					+ "AND mdpMedecin = MD5('" + mdp + "')").getResultList().isEmpty()) {
				resultat = false;
			} else {
				resultat = true;
			}	
		}
		return resultat;
	}
	
	/**
	 * Ajoute un aide dans la base de donnees
	 */
//	public void ajouterAide(String adresse, String date, String mail, String nom, String prenom, String tel, String mdpAide, String idMedecin) throws ParseException {
//		//creer medecin
//		Medecin medecin = new Medecin
//		Aide aide = new Aide(adresse, date, mail,nom, prenom, tel,mdpAide,trouverMedecin.idMedecin(idMedecin));
//		em.persist(aide);
//	}
	
	/**
	 * Ajoute un aidant dans la base de donnees
	 */
	public void ajouterAidant(String mailAidant, String adresseAidant, String ddnAidant, String telAidant, String mdpAidant, String type, Boolean referent, String nomAidant, String prenomAidant) throws ParseException {
		Aidant aidant = new Aidant(mailAidant, adresseAidant, ddnAidant, telAidant, encode(mdpAidant), type, referent, nomAidant, prenomAidant);
		em.persist(aidant);
	}
	
	
//	public Medecin getMedecin()
//	public List<Medecin> renvoiMedecins(){
//		Medecin m=new Medecin();
//		em.persist(m);
//		 em.createQuery("select  from medecin m order by m.nom asc").getResultList();
//	}
	
	/**
	 * Fonction trouvée sur le net qui transforme un mot de type String en 
	 */
	 private static String encode(String password)
	    {
	        byte[] uniqueKey = password.getBytes();
	        byte[] hash      = null;

	        try
	        {
	            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	            throw new Error("No MD5 support in this VM.");
	        }

	        StringBuilder hashString = new StringBuilder();
	        for (int i = 0; i < hash.length; i++)
	        {
	            String hex = Integer.toHexString(hash[i]);
	            if (hex.length() == 1)
	            {
	                hashString.append('0');
	                hashString.append(hex.charAt(hex.length() - 1));
	            }
	            else
	                hashString.append(hex.substring(hex.length() - 2));
	        }
	        return hashString.toString();
	    }

	
	
}