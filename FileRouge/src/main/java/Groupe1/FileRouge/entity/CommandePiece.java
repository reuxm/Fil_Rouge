package Groupe1.FileRouge.entity;

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
@Table( name="commande_piece" )
public class CommandePiece {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@ManyToOne
	@JoinColumn( name="id_user", nullable=false )
	private User user;

	@ManyToOne
	@JoinColumn( name="id_user", nullable=false )
	private Piece piece;
	
	@Column( name="quantite", nullable=false )
	private Integer qte;
	
	@Temporal(TemporalType.DATE)
	@Column( name="date_creation", nullable=false )
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	@Column( name="date_cloture", nullable=true )
	private Date dateCloture;
	
}
