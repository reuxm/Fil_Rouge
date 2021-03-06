package groupe1.filrouge.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import java.util.Collection;


/**
 * @author Matiace
 * @version 1.0
 * @since 2020-01-16 <br>
 * <b> Java Doc pour le projet fil rouge</b>
 */

@Entity
@Table(name = "users")
@NamedQueries({
	@NamedQuery(
		name="User.get",
		query="select u from User u where u.login like ?1"
	)
})
public class User {

	/**
	 * JAVADOC Id User est génerer par Hibernate
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Integer id;
	
	/**
	 * JAVADOC prénom du User : obligatoire
	 */
	@Column(name="firstname", length = 50, nullable = false)
	private String firstname;
	
	/**
	 * JAVADOC nom de User : obligatoire
	 */
	@Column(name="lastname", length = 50, nullable = false)
	private String lastname;
	
	/**
	 * JAVADOC Login de User : obligatoire
	 */
	@Column(name="login", length = 15, nullable = false)
	private String login;
	
	/**
	 * JAVADOC mot de passe de User : obligatoire
	 */
	@Column(name="pwd", length = 10, nullable = false)
	private String password;

	/**
	 * Indique que le compte utilisateur est bloque 
	 */
	@Column(name="suspended")
	private Boolean suspended;
	
	/**
	 * JAVADOC Jointure des deux table user et profil
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="profil_user",
	joinColumns= @JoinColumn(name = "id_user"),
	inverseJoinColumns= @JoinColumn(name="id_profil") ) 
	private Collection<Profil> profils;
	
	/**
	 * 
	 * @return <b> L'Id User </b>
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Insertion d'Id User 
	 * @param Id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 
	 * @return <b> Le prénom du User </b>
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * Insertion Prénom User 
	 * @param firstname
	 */
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}
	/**
	 * 
	 * @return <b> Le prénom du User </b>
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * Insertion Prénom User 
	 * @param lastname
	 */
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}
	/**
	 * 
	 * @return <b> Le login du User </b>
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Insertion login User 
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * 
	 * @return <b> Le password du User </b>
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Insertion password User 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Profil> getProfils() {
		return profils;
	}

	public void setProfils(Collection<Profil> profils) {
		this.profils = profils;
	}
	
	public Boolean getSuspended() {
		return suspended;
	}
	
	public void setSuspended(Boolean suspended) {
		this.suspended = suspended;
	}
	
	public void toogleSupended() {
		setSuspended( !getSuspended() );
	}

}
