package groupe1.filrouge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Bassel Gaied
 * @version 1.0
 * @since 2020-01-16 <br>
 * <b> Java Doc pour le projet fil rouge</b>
 */

@Entity
@Table(name = "client")
public class Client {
	/**
	 * JAVADOC Id Client est génerer par Hibernate
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * JAVADOC prénom de Client : obligatoire
	 */
	@Column(name = "nom", length = 50, nullable = false)
	private String name;
	/**
	 * JAVADOC prénom du Client : obligatoire
	 */
	@Column(name = "prenom", length = 50, nullable = false)
	private String firstname;
	/**
	 * JAVADOC adresse du Client : obligatoire
	 */
	@Column(name = "adresse", length = 50, nullable = false)
	private String adresse;
	/**
	 * JAVADOC code postale du Client : obligatoire
	 */
	@Column(name = "code_postal", length = 50, nullable = false)
	private String codePostal;
	/**
	 * JAVADOC ville du Client : obligatoire
	 */
	@Column(name = "ville", length = 50, nullable = false)
	private String ville;
	/**
	 * JAVADOC telephone du Client : obligatoire
	 */
	@Column(name = "telephone", length = 50, nullable = false)
	private String telephone;
	/**
	 * JAVADOC mobile du Client : obligatoire
	 */
	@Column(name = "mobile", length = 50, nullable = false)
	private String mobile;
	/**
	 * JAVADOC Boolean type pour savoir si la demande du client est cloturer ou non
	 */
	@Column(name = "cloturer")
	private Boolean cloturer;
	/**
	 * 
	 * @return <b> L'Id Client </b>
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Insertion d'Id Client 
	 * @param Id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 
	 * @return <b> Le prénom du Client </b>
	 */
	public String getName() {
		return name;
	}
	/**
	 * Insertion Prénom Client 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return <b> Le Nom du Client </b>
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * Insertion Nom Client 
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * 
	 * @return <b> L'adresse du client </b>
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * Insertion Adresse Client 
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * 
	 * @return <b> La ville du client </b>
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * Insertion Ville Client 
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * 
	 * @return <b> Le teléphone du client </b>
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * Insertion Telephone Client 
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * 
	 * @return <b> Le mobile du Client </b>
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * Insertion Mobile Client 
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 
	 * @return <b> Le code postale du Client</b>
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * Insertion Code Postale Client 
	 * @param codepostale
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * 
	 * @return <b> La cloture vrai ou faux </b>
	 */
	public Boolean getCloturer() {
		return cloturer;
	}
	/**
	 * Insertion Cloture Client 
	 * @param cloture
	 */
	public void setCloturer(Boolean cloturer) {
		this.cloturer = cloturer;
	}

}
