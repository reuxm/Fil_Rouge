package groupe1.filrouge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table( name="pieces" )
public class Piece {
	/**
	 * JAVADOC Id Piece est génerer par Hibernate
	 */
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column( name="libelle", length = 50, nullable=false )
	private String libelle;
	/**
	 * JAVADOC la quantité des pieces
	 */
	@Column( name="quantite", nullable=true )
	private Integer qte;
	/**
	 * JAVADOC la date de création du piece 
	 */
	@Temporal(TemporalType.DATE)
	@Column( name="date_saisie", nullable=true )
	private Date dateCreation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
}
