package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entite.Aidant;
import entite.Aide;
import entite.CompteRendu;
import entite.Medecin;


//----------------------------------------SINGLETON ----------------------------------------
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
	

// -------------------------------------CONFIGURATION -------------------------------------
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

	// -------------------------------FONCTION VERIFCONNECTION -------------------------------------
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
					+ "AND mdpAide = MD5('" + mdp + "')").getResultList().isEmpty()) {
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
	
	// -------------------------------FONCTION VERIFREFERENT -------------------------------------
		/**
		 * La fonction renvoie true si la personne est un aidant référent et non sinon
		 */
		public Boolean verifReferent(String mail, String mdp, String nomTable) {
			Boolean resultat = false;
			if (nomTable.equals("aidant")) {
				if (!em.createQuery("select nomAidant from Aidant where mailaidant = '" + mail + "'"
						+ " AND mdpAidant = MD5('" + mdp + "') AND referent = " + true).getResultList().isEmpty()) {
					resultat = true;
				} 
				}
			return resultat;
			} 
			
	
			

	
	// -------------------------------------AJOUTS DE PERSONNES -------------------------------------
	/**
	 * Ajoute un aide dans la base de donnees
	 * @throws ParseException 
	 */
	//pr Git
	public void ajouterAide(Aide aide) throws ParseException {
		aide.setMdpAide(encode(aide.getMdpAide()));
		em.persist(aide);
		commit();
		}
	
	/**
	 * Ajoute un aidant dans la base de donnees
	 */
	public void ajouterAidant(Aidant aidant) throws ParseException {
		aidant.setMdpAidant(encode(aidant.getMdpAidant()));
		em.persist(aidant);
		commit();		
	}

	// -------------------------------RENVOI DES LISTES DE PERSONNES -------------------------------------

	/**
	 * Créer une instance de Médecin et l'ajoute au contexte de persistance.
	 * @return le médecin créé
	 */
	public Medecin getMedecin(String mdpMedecin, String adressePro, String mailMedecin, String nom, String prenom, String telMedecin, Integer premiereConnection) {
	Medecin m = new Medecin(mdpMedecin, adressePro, mailMedecin, nom, prenom, telMedecin, premiereConnection);
	em.persist(m);
	return m;
	}
	
	
	/**
	 * Retourne le contenu de la table Médecin
	 */
	public List<Medecin> renvoiMedecins(){
		return em.createQuery("select m from Medecin m order by m.nom asc").getResultList();
	}
	
	/**
	 * Créer une instance de Aidant et l'ajoute au contexte de persistance.
	 * @return le aidant créé
	 * @throws ParseException 
	 */
	public Aidant getAidant(String adresseAidant, String ddnAidant,String mailAidant, String mdpAidant, String nomAidant, String prenomAidant,  Boolean referent, String telAidant, String type) throws ParseException {
		Aidant a = new Aidant( adresseAidant,  ddnAidant, mailAidant,  mdpAidant,  nomAidant,  prenomAidant,   referent,  telAidant,  type);
		em.persist(a);
		return a;
	}
	
	
	/**
	 * Retourne le contenu de la table Aidant
	 */
	public List<Aidant> renvoiAidants(){
		return em.createQuery("select a from Aidant a order by a.nomAidant asc").getResultList();
	}
	
	/**
	 * Créer une instance de Aide et l'ajoute au contexte de persistance.
	 * @return la personne aidée est créée
	 * @throws ParseException 
	 */
	public Aide getAide(String adresse, String ddn,String mail, String mdpAide, String nom, String prenom, String tel, Medecin medecin) throws ParseException {
		Aide a = new Aide( adresse,  ddn, mail,  mdpAide,  nom,  prenom,  tel,  medecin);
		em.persist(a);
		return a;
	}
	
	
	/**
	 * Retourne le contenu de la table Aide
	 */
	public List<Aide> renvoiAides(){
		return em.createQuery("select a from Aide a order by a.nom asc").getResultList();
	}
	
	// -------------------------------------SUPPRESSION DE PERSONNES -------------------------------------

	/**
	 * efface une aide
	 * @param a  l'aide
	 */
	public void supprimerAide(Aide a){
		em.remove(a);
		tx.commit();
	}
	
	/**
	 * efface une aide
	 * @param a  l'aide
	 */
	public void supprimerAidant(Aidant a){
		em.remove(a);
		tx.commit();
	}
	
	
	// -----------------------------FONCTIONS DE RECHERCHE DE PERSONNE PAR ID-------------------------------------
	
	/**Retourne un medecin selectionné par son id
    @param id l'id du medecin recherché
    @return le medecin
    */
	public Medecin trouverMedecin(int id){
        return em.find(Medecin.class, id);
    }
	
	/**Retourne un aidant selectionné par son id
    @param id l'id de l'aidant recherché
    @return l'aidant
    */
	public Aidant trouverAidant(int id){
        return em.find(Aidant.class, id);
    }
	
	/**Retourne un aidé selectionné par son id
    @param id l'id de l'aidé recherché
    @return l'aidé
    */
	public Aide trouverAide(int id){
        return em.find(Aide.class, id);
    }
	
	// ----------------------------FONCTION DE CRYPTAGE EN MD5 -------------------------------------

	/**
	 * Fonction trouvée sur internet qui transforme un mot de type String en 
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