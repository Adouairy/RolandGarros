package entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@SuppressWarnings("unused")
	@Entity
	@Table(name = "court")
	public class Court implements Cloneable {
		
		@Id
		@Column(name = "IDCOURT", nullable = false)
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;

		@Column(name = "NOM", length = 50, nullable = true)
		private String nom;

		@Column(name = "DISPONIBILITE", length = 1, nullable = true)
		private Boolean disponibilite;

		//constructeurs
		public Court() {
		}
		
		
		/**
		 * @param nom
		 * @param disponibilite
		 */
		public Court(String nom, Boolean disponibilite) {
			setNom(nom);
			setDisponibilite(disponibilite);
	
		}

		
		//accesseurs
		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public Boolean getDisponibilite() {
			return disponibilite;
		}


		public void setDisponibilite(Boolean disponibilite) {
			this.disponibilite = disponibilite;
		}


		//ToString
		@Override
		public String toString() {
			return "Court [id=" + id + ", nom=" + nom + ", disponibilite=" + disponibilite + "]";
		}

		
		

}
