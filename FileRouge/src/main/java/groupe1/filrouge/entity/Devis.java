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
 * @author Bassel Gaied
 * @version 1.0
 * @since 2020-01-16 <br>
 * <b> Java Doc pour le projet fil rouge</b>
 */
@Entity
@Table(name = "devis")
public class Devis {
	/**
	 * JAVADOC Id Devis est génerer par Hibernate
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * JAVADOC Création du clé étranger idclient pour pointer au objet client
	 */
	@ManyToOne
	@JoinColumn(name = "id_client", nullable = false)
	private Client client;
	/**
	 * JAVADOC Création du clé étranger idvehicule pour pointer au objet voiture
	 */
	@ManyToOne
	@JoinColumn(name = "id_vehicule", nullable = false)
	private Vehicule vehicule;
	/**
	 * JAVADOC Création du clé étranger iduser pour pointer au objet user
	 */
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;
	/**
	 * JAVADOC la date de création du devis : obligatoire
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date_creation", nullable = false)
	private Date dateCreation;
	/**
	 * JAVADOC la date de création du voiture : obligatoire
	 */
	@Column(name = "etatdevis", nullable = false)
	private Boolean etat;
	/**
	 * 
	 * @return <b> L'Id Devis </b>
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Insertion d'Id Devis 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 
	 * @return <b> Date de création devis </b>
	 */
	public Date getDateCreation() {
		return dateCreation;
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
	 * @return <b> Renvoie d'objet vehicule </b>
	 */
	public Vehicule getVehicule() {
		return vehicule;
	}
	/**
	 * Insertion Voiture 
	 * @param voiture
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
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
	 * Insertion Date de création Devis 
	 * @param dateCreation
	 */
	public void setDatecreation(Date datecreation) {
		this.dateCreation = datecreation;
	}
	/**
	 * 
	 * @return <b> Etat devis </b>
	 */
	public Boolean getEtat() {
		return etat;
	}
	/**
	 * Type boolean pour savoir que le devis et valider ou non 
	 * @param etat
	 */
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}


}
