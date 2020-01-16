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

@Entity
@Table(name = "fiche") 
public class Fiche {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_creation",nullable=false)
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_cloture",nullable=true)
	private Date dateCloture;
	
	@Column(name="etatfiche", nullable=false)
	private Boolean etat;
	
	@ManyToOne
	@JoinColumn(name="id_user",  nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id_priorite",  nullable = false)
	private Priorite priorite;
	
	@ManyToOne
	@JoinColumn(name="id_client",  nullable = false)
	private Client client;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateCloture() {
		return dateCloture;
	}

	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}

	public Boolean getEtatFiche() {
		return etat;
	}

	public void setEtatFiche(Boolean etatFiche) {
		this.etat = etatFiche;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Priorite getPriorite() {
		return priorite;
	}

	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
