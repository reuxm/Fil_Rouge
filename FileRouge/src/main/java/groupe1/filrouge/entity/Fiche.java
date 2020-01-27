package groupe1.filrouge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * @author Marie
 * @version 1.0
 * @since 2020-01-16 <br>
 * <b> Java Doc pour le projet fil rouge</b>
 */
@Entity
@Table(name = "fiche") 
public class Fiche {
	/**
	 * JAVADOC Id Devis est génerer par Hibernate
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Integer id;
	/**
	 * JAVADOC la date de création du fiche : obligatoire
	 */
	@Temporal(TemporalType.DATE)
	@Column(name="date_creation",nullable=false)
	private Date dateCreation;
	/**
	 * JAVADOC la date de cloture du fiche
	 */
	@Temporal(TemporalType.DATE)
	@Column(name="date_cloture",nullable=true)
	private Date dateCloture;
	/**
	 * JAVADOC l'état du fiche : obligatoire
	 */
	@Column(name="etatfiche", nullable=false)
	private Boolean etat;
	/**
	 * JAVADOC Création du clé étranger iduser pour pointer au objet user
	 */
	@ManyToOne
	@JoinColumn(name="id_user",  nullable = false)
	private User user;
	/**
	 * JAVADOC Création du clé étranger idpriorite pour pointer au objet priorite
	 */
	@ManyToOne
	@JoinColumn(name="id_priorite",  nullable = false)
	private Priorite priorite;
	/**
	 * JAVADOC Création du clé étranger idclient pour pointer au objet client
	 */
	@ManyToOne
	@JoinColumn(name="id_client",  nullable = false)
	private Client client;
	/**
	 * JAVADOC Création d'une discription d'une fiche
	 */
	@Column( name="description", columnDefinition = "text", nullable=true )
	private String description;
	/**
	 * JAVADOC Création du tva de fiche
	 */
	@Column( name="tauxTVA", nullable=true )
	private Float tva;
	/**
	 * JAVADOC Création prix fiche
	 */
	@Column( name="prixHT", nullable=true)
	private Float prix;
	/**
	 * 
	 * @return <b> L'Id Fiche </b>
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Insertion d'Id Fiche 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 
	 * @return <b> Date de création fiche </b>
	 */
	public Date getDateCreation() {
		return dateCreation;
	}
	/**
	 * Insertion Date de création fiche 
	 * @param dateCreation
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	/**
	 * 
	 * @return <b> Date de cloture fiche </b>
	 */
	public Date getDateCloture() {
		return dateCloture;
	}
	/**
	 * Insertion Date de cloture fiche 
	 * @param dateCreation
	 */
	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}
	/**
	 * 
	 * @return <b> Renvoie d'objet user </b>
	 */
	public User getUser() {
		return user;
	}
	/**
	 * Insertion User 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 
	 * @return <b> priorite fiche </b>
	 */
	public Priorite getPriorite() {
		return priorite;
	}
	/**
	 * Avoir la priorete de fiche s'il est urgante ou pas 
	 * @param priorite
	 */
	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}
	/**
	 * 
	 * @return <b> Renvoie d'objet client </b>
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * Insertion Client 
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/**
	 * 
	 * @return <b> Etat fiche </b>
	 */
	public Boolean getEtat() {
		return etat;
	}
	/**
	 * Type boolean pour savoir que la fiche et valider ou non 
	 * @param etat
	 */
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	/**
	 * 
	 * @return <b> Une discription de la fiche </b>
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Description fiche 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 
	 * @return <b> le tva fiche </b>
	 */
	public Float getTva() {
		return tva;
	}
	/**
	 * tva fiche 
	 * @param tva
	 */
	public void setTva(Float tva) {
		this.tva = tva;
	}
	/**
	 * 
	 * @return <b> Prix fiche </b>
	 */
	public Float getPrix() {
		return prix;
	}
	/**
	 * prix fiche 
	 * @param prix
	 */
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	
}
