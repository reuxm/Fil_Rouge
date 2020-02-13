package groupe1.filrouge.security.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import groupe1.filrouge.entity.Profil;

@Entity
@Table(name = "users") 
public class UserDet implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		final List<GrantedAuthority> authorities = 
				new ArrayList<GrantedAuthority>();
		for (final Profil role : this.getProfils()) {
			authorities.add(
					new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
