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

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import entite.Aidant;
import entite.Aide;
import entite.CompteRendu;
import entite.Cooperation;
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

	/**
	 * Synchronise le context de persistance avec la base de donnee. En fait un
	 * commit est effectue et une nouvelle transaction d�but�e
	 */
	public void connection() {
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

	// -------------------------------FONCTION VERIFCONNECTION-------------------------------------
	/**
	 * La fonction renvoie true si la personne a bien entre un nom et un mot de
	 * passe valides
	 * 
	 * @return true si c'est ok et false si erreur de connection
	 */
	public Boolean verifConnection(String mail, String mdp, String nomTable) {
		connection();
		Boolean resultat = true;
		if (nomTable.equals("aidant")) {
			if (em.createQuery("select nomAidant from Aidant where mailAidant = '" + mail + "'"
					+ " AND mdpAidant = MD5('" + mdp + "')").getResultList().isEmpty()) {
				resultat = false;
			} else {
				resultat = true;
			}
		} else if (nomTable.equals("aide")) {
			if (em.createQuery("select nom from Aide where mail = '" + mail + "'" + "AND mdpAide = MD5('" + mdp + "')")
					.getResultList().isEmpty()) {
				resultat = false;
			} else {
				resultat = true;
			}
		} else {
			if (em.createQuery("select mailMedecin from Medecin where mailMedecin = '" + mail + "'"
					+ "AND mdpMedecin = MD5('" + mdp + "')").getResultList().isEmpty()) {
				resultat = false;
			} else {
				resultat = true;
			}
		}
		closeAll();
		return resultat;
	}

	// -------------------------------FONCTION VERIFREFERENT-------------------------------------
	/**
	 * La fonction renvoie true si la personne est un aidant référent et non
	 * sinon
	 */
	public Boolean verifReferent(String mail, String mdp, String nomTable) {
		connection();
		Boolean resultat = false;
		if (nomTable.equals("aidant")) {
			if (!em.createQuery("select nomAidant from Aidant where mailaidant = '" + mail + "'"
					+ " AND mdpAidant = MD5('" + mdp + "') AND referent = " + true).getResultList().isEmpty()) {
				resultat = true;
			}
		}
		closeAll();
		return resultat;
	}

	// -------------------------------------AJOUTS DE PERSONNES(Objets)-------------------------------------
	/**
	 * Ajoute un aide dans la base de donnees
	 * 
	 * @throws ParseException
	 */
	// pr Git
	public void ajouterAide(Aide aide) throws ParseException {
		connection();
		aide.setMdpAide(encode(aide.getMdpAide()));
		em.persist(aide);
		tx.commit();
		closeAll();
		
	}

	/**
	 * Ajoute un aidant dans la base de donnees
	 */
	public void ajouterAidant(Aidant aidant) throws ParseException {
		connection();
		aidant.setMdpAidant(encode(aidant.getMdpAidant()));
		em.persist(aidant);
		tx.commit();
		closeAll();
	}

	/**
	 * Ajoute un objet cooperation dans la base de donnees lien entre un aidé et
	 * un aidant
	 */
	public void ajouterCooperation(Aidant aidant, Aide aide) throws ParseException {
		connection();
		Cooperation cooperation = new Cooperation(aidant, aide);
		em.persist(cooperation);
		tx.commit();
		closeAll();
	}
	//--------------------------------UPDATE--------------------------------------------------------------------
	
	/**
     * Mettre à jour un aidant dans la base de donnée
     */
    public void UpdateAidant(Aidant aidant){
        connection();
		aidant.setMdpAidant(encode(aidant.getMdpAidant()));
        em.merge(aidant);
        tx.commit();
        closeAll();
    }

	// -------------------------------RENVOI DES LISTES DE PERSONNES(objets)-------------------------------------

	/**
	 * Créer une instance de Médecin et l'ajoute au contexte de persistance.
	 * 
	 * @return le médecin créé
	 */
	public Medecin getMedecin(String mdpMedecin, String adressePro, String mailMedecin, String nom, String prenom,
			String telMedecin, Integer premiereConnection) {
		connection();
		Medecin m = new Medecin(mdpMedecin, adressePro, mailMedecin, nom, prenom, telMedecin, premiereConnection);
		em.persist(m);
		closeAll();
		return m;
	}

	/**
	 * Retourne le contenu de la table Médecin
	 */
	public List<Medecin> renvoiMedecins() {
		connection();
		List<Medecin> liste = em.createQuery("select m from Medecin m order by m.nom asc").getResultList();
		closeAll();
		return liste;
	}

	/**
	 * Créer une instance de Aidant et l'ajoute au contexte de persistance.
	 * 
	 * @return le aidant créé
	 * @throws ParseException
	 */
	public Aidant getAidant(String adresseAidant, String ddnAidant, String mailAidant, String mdpAidant,
			String nomAidant, String prenomAidant, Boolean referent, String telAidant, String type)
			throws ParseException {
		connection();
		Aidant a = new Aidant(adresseAidant, ddnAidant, mailAidant, mdpAidant, nomAidant, prenomAidant, referent,
				telAidant, type);
		em.persist(a);
		closeAll();
		return a;
	}

	/**
	 * Retourne le contenu de la table Aidant
	 */
	public List<Aidant> renvoiAidants() {
		connection();
		List<Aidant> liste = em.createQuery("select a from Aidant a order by a.nomAidant asc").getResultList();
		closeAll();
		return liste;
	}

	/**
	 * Créer une instance de Aide et l'ajoute au contexte de persistance.
	 * 
	 * @return la personne aidée est créée
	 * @throws ParseException
	 */
	public Aide getAide(String adresse, String ddn, String mail, String mdpAide, String nom, String prenom, String tel,
			Medecin medecin) throws ParseException {
		connection();
		Aide a = new Aide(adresse, ddn, mail, mdpAide, nom, prenom, tel, medecin);
		em.persist(a);
		closeAll();
		return a;
	}

	/**
	 * Retourne le contenu de la table Aide
	 */
	public List<Aide> renvoiAides() {
		connection();
		List<Aide> liste = em.createQuery("select a from Aide a order by a.nom asc").getResultList();
		closeAll();
		return liste;
	}

	/**
	 * Créer une instance de Cooperation et l'ajoute au contexte de persistance.
	 * 
	 * @return la cooperation entre personne aidée et personne aidante
	 * @throws ParseException
	 */
	public Cooperation getCooperation(Aidant aidant, Aide aide) {
		connection();
		Cooperation cooperation = new Cooperation(aidant, aide);
		em.persist(cooperation);
		closeAll();
		return cooperation;
	}

	/**
	 * Retourne le contenu de la table Cooperation
	 */
	public List<Cooperation> renvoiCooperations() {
		connection();
		List<Cooperation> liste = em.createQuery("select cooperation from Cooperation cooperation").getResultList();
		//CloseAll()
		return liste;
	}

	// -------------------------------------SUPPRESSION DE PERSONNES-------------------------------------

	/**
	 * Supprimer une personne aidée
	 * @param a:l'aidée
	 */
	public void supprimerAide(Aide a) {
		connection();
		em.remove(a);
		tx.commit();
		closeAll();
	}

	/**
	 * Supprimer un aidant
	 * @param a:l'aidant
	 */
	public void supprimerAidant(Aidant a) {
		connection();
		em.remove(a);
		tx.commit();
		closeAll();
	}

	public void supprimerCooperation(Aidant a) {
		connection();
		for (Cooperation cooperation : renvoiCooperations()) {
			if (a.getIdAidant() == cooperation.getAidant().getIdAidant()) {
				em.remove(cooperation);
			}
		}

		tx.commit();
		closeAll();
	}

	// -----------------------------FONCTIONS DE RECHERCHE DE PERSONNE PAR ID-------------------------------------

	/**
	 * Retourne un medecin selectionné par son id
	 * 
	 * @param id
	 *            l'id du medecin recherché
	 * @return le medecin
	 */
	public Medecin trouverMedecin(int id) {
		connection();
		Medecin m = em.find(Medecin.class, id);
		return m;
	}

	/**
	 * Retourne un aidant selectionné par son id
	 * 
	 * @param id
	 *            l'id de l'aidant recherché
	 * @return l'aidant
	 */
	public Aidant trouverAidant(int id) {
		connection();
		Aidant a = em.find(Aidant.class, id);
		return a;
	}

	/**
	 * Retourne un aidé selectionné par son id
	 * 
	 * @param id
	 *            l'id de l'aidé recherché
	 * @return l'aidé
	 */
	public Aide trouverAide(int id) {
		connection();
		Aide a = em.find(Aide.class, id);
		return a;
	}
	
	
	/**
	 * selectionner le médecin référent associé à un aidé
	 * @param aide
	 * @return
	 */
	public Medecin trouverMedecinParAide(Aide aide) {
		connection();
		List<Integer> idmedecin = em.createQuery("SELECT a.medecin.idMedecin FROM Aide a WHERE a.id = "+aide.getId()).getResultList();
		System.out.println(idmedecin.get(0));
		Medecin m = trouverMedecin(idmedecin.get(0));
		closeAll();
		return m;
	}

	public Aidant trouverReferentParAide(Aide aide){
		connection();
		List<Aidant> aidantCoop = em.createQuery("SELECT cooperation.aidant FROM Cooperation cooperation WHERE cooperation.aidant.referent=true AND cooperation.aide.id="+aide.getId()).getResultList();
		Aidant a = aidantCoop.get(0);
		return a;
	}
	
	public List<Aidant> trouverAidantsParAide(Aide aide){
		connection();
		List<Aidant> aidants = em.createQuery("SELECT cooperation.aidant FROM Cooperation cooperation WHERE cooperation.aide.id="+aide.getId()).getResultList();
		return aidants;
	}
	
	public List<Aide> trouverAidesParMedecin(Medecin medecin){
		connection();
		List<Aide> aides = em.createQuery("SELECT a FROM Aide a WHERE a.medecin.idMedecin="+medecin.getIdMedecin()).getResultList();
		return aides;
	}
	// ----------------------------FONCTION DE CRYPTAGE EN MD5-------------------------------------

	/**
	 * Fonction qui transforme un mot de type String en
	 */
	private static String encode(String password) {
		byte[] uniqueKey = password.getBytes();
		byte[] hash = null;

		try {
			hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		} catch (NoSuchAlgorithmException e) {
			throw new Error("No MD5 support in this VM.");
		}

		StringBuilder hashString = new StringBuilder();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			} else
				hashString.append(hex.substring(hex.length() - 2));
		}
		return hashString.toString();
	}

}