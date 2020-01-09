package Groupe1.FileRouge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name="pieces" )
public class Piece {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column( name="libelle", length = 50, nullable=false )
	private String libelle;
	
	@Column( name="quantite", nullable=false )
	private Integer qte;
	
	@Temporal(TemporalType.DATE)
	@Column( name="date_creation", nullable=false )
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

	@Override
	public String toString() {
		return "Piece [id=" + id + ", libelle=" + libelle + ", qte=" + qte + ", dateCreation=" + dateCreation + "]";
	}
	
}
