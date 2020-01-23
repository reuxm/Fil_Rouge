package groupe1.filrouge.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Collection;


@Entity
@Table(name = "users") 
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Integer id;
	
	@Column(name="firstname", length = 50, nullable = false)
	private String firstname;

	@Column(name="lastname", length = 50, nullable = false)
	private String lastname;
	
	@Column(name="login", length = 15, nullable = false)
	private String login;
	
	@Column(name="pwd", length = 10, nullable = false)
	private String password;

	
	@ManyToMany
	@JoinTable(name="profil_user",
	joinColumns= @JoinColumn(name = "id_user"),
	inverseJoinColumns= @JoinColumn(name="id_profil") ) 
	private Collection<Profil> profils;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Profil> getProfils() {
		return profils;
	}

	public void setProfils(Collection<Profil> profils) {
		this.profils = profils;
	}
	
}
