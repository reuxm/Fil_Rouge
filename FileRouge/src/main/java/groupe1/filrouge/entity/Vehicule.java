package groupe1.filrouge.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Bassel Gaied
 * @version 1.0
 * @since 2020-01-16 <br>
 * <b> Java Doc pour le projet fil rouge</b>
 */

@Entity
@Table(name = "vehicule")
public class Vehicule {
	/**
	 * JAVADOC Id Vehicule est génerer par Hibernate
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * JAVADOC modele du voiture : obligatoire
	 */
	@Column(name = "modele", length = 50, nullable = false)
	private String modele;
	/**
	 * JAVADOC la quantité du voiture : obligatoire
	 */
	@Column(name = "quantite", length = 11, nullable = false)
	private Integer qte;
	/**
	 * JAVADOC le prix du voiture
	 */
	@Column(name = "prixHT")
	private Float prixHT;
	/**
	 * JAVADOC la date de création du voiture : obligatoire
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date_creation", nullable = false)
	private Date dateCreation;
	/**
	 * JAVADOC la voiture peut avoir une liste de devis
	 */
	@OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY)
	private List<Devis> listeDevis;
	/**
	 * JAVADOC modele du voiture : obligatoire
	 * @return listeDevis
	 */
	public List<Devis> getListeDevis() {
		return listeDevis;
	}
	/**
	 * 
	 * @return <b> Liste des devis </b>
	 */
	public void setListeDevis(List<Devis> listeDevis) {
		this.listeDevis = listeDevis;
	}
	/**
	 * 
	 * @return <b> L'Id Voiture </b>
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Insertion d'Id Voiture 
	 * @param Id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 
	 * @return <b> Modele Voiture </b>
	 */
	public String getModele() {
		return modele;
	}
	/**
	 * Insertion du Modele Voiture 
	 * @param modele
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}
	/**
	 * 
	 * @return <b> la quantité Voiture </b>
	 */
	public Integer getQte() {
		return qte;
	}
	/**
	 * Insertion de la quantité des voiture
	 * @param quantite
	 */
	public void setQte(Integer quantite) {
		this.qte = quantite;
	}
	/**
	 * 
	 * @return <b> Le prix du Voiture </b>
	 */
	public Float getPrixHT() {
		return prixHT;
	}
	/**
	 * Insertion de prix Voiture 
	 * @param prix
	 */
	public void setPrixHT(Float prixHT) {
		this.prixHT = prixHT;
	}
	/**
	 * 
	 * @return <b> La date de création duVoiture </b>
	 */
	public Date getDateCreation() {
		return dateCreation;
	}
	/**
	 * Insertion de la date de création Voiture 
	 * @param date_creation
	 */
	public void setDateCreation(Date date_creation) {
		this.dateCreation = date_creation;
	}

}
