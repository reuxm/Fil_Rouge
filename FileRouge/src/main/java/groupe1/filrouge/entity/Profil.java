package groupe1.filrouge.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 * @author Matiace
 * @version 1.0
 * @since 2020-01-16 <br>
 * <b> Java Doc pour le projet fil rouge</b>
 */
@Entity
@Table(name="profil")

public class Profil {
	/**
	 * JAVADOC Id Profil est génerer par Hibernate
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Integer id;
	/**
	 * JAVADOC prénom de Client : obligatoire
	 */
	@Column(name="name", length = 50, nullable = false)
	private String name;
  
	@JsonBackReference
	@ManyToMany
	@JoinTable(name="profil_user",
	joinColumns= @JoinColumn(name = "id_profil"),
	inverseJoinColumns= @JoinColumn(name="id_user") ) 
	private Collection<User> users;

	/**
	 * 
	 * @return <b> L'Id Profil </b>
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Insertion d'Id Profil 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 
	 * @return <b> Le prénom du Profil </b>
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

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

}
