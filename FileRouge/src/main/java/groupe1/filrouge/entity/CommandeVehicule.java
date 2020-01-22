package groupe1.filrouge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name="commande_vehicule" ) 
public class CommandeVehicule {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@OneToOne
	@JoinColumn( name="id_devis", nullable=true )
	private Devis devis;

	@Column( name="etat", nullable=true )
	private Boolean etat;
	
	@Temporal(TemporalType.DATE)
	@Column( name="date_creation", nullable=true )
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	@Column( name="date_cloture", nullable=true )
	private Date dateCloture;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat= etat;
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

}
