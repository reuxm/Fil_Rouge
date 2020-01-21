package groupe1.filrouge.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tache")
public class Tache {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column( name="commentaire", length = 200, nullable=true)
	private String commentaire;
	
	@Column( name="qte", nullable=true )
	private Integer qte;
	
	@Column(name="etattache", nullable=true)
	private Boolean etat;
	
	@ManyToOne
	@JoinColumn( name="id_user", nullable=false )
	private User user;
	
	@ManyToOne
	@JoinColumn( name="id_fiche", nullable=false )
	private Fiche fiche;
	
	@ManyToOne
	@JoinColumn( name="id_priorite", nullable=false )
	private Priorite priorite;
	
	@ManyToOne
	@JoinColumn( name="id_piece", nullable=false )
	private Piece piece;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etatTache) {
		this.etat = etatTache;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Fiche getFiche() {
		return fiche;
	}

	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}

	public Priorite getPriorite() {
		return priorite;
	}

	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	@Override
	public String toString() {
		return "Tache [id=" + id + ", commentaire=" + commentaire + ", qte=" + qte + ", etat=" + etat + ", user=" + user
				+ ", fiche=" + fiche + ", priorite=" + priorite + ", piece=" + piece + "]";
	}
	
	
	
}
