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
@Table(name="facture_fiche")
public class FactureFiche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_fiche", nullable=false)
	private Fiche fiche;


	@Column( name="prixHT", nullable=true)
	private float prixHT;
	
	@Column( name="tauxTVA", nullable=true )

	private float TVA;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_creation", nullable = false)
	private Date dateCreation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Fiche getFiche() {
		return fiche;
	}

	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}

	public float getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}

	public float getTVA() {
		return TVA;
	}

	public void setTVA(float tVA) {
		TVA = tVA;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

}
