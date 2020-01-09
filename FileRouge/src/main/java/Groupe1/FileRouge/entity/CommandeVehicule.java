package Groupe1.FileRouge.entity;

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

	@Column( name="etatdevis", nullable=true, columnDefinition = "0" )
	private Boolean etat;
	
	@Temporal(TemporalType.DATE)
	@Column( name="date_creation", nullable=true )
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	@Column( name="date_cloture", nullable=true )
	private Date dateCloture;
	
	

}
