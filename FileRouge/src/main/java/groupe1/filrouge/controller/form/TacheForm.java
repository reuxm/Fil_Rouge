package groupe1.filrouge.controller.form;



import javax.validation.constraints.PositiveOrZero;

public class TacheForm {
	
	private Integer id;
	

	private String commentaire;
	

	@PositiveOrZero(message="La quantité ne peux pas être négative")
	private Integer qte;
	
	private Boolean etat = false;
	

	private Integer user;
	

	private Integer fiche;
	
	private String libelle;
	private Integer priorite;
	

	private Integer piece;

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

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getFiche() {
		return fiche;
	}

	public void setFiche(Integer fiche) {
		this.fiche = fiche;
	}

	public Integer getPriorite() {
		return priorite;
	}

	public void setPriorite(Integer priorite) {
		this.priorite = priorite;
	}

	public Integer getPiece() {
		return piece;
	}

	public void setPiece(Integer piece) {
		this.piece = piece;
	}

	@Override
	public String toString() {
		return "TacheForm [id=" + id + ", commentaire=" + commentaire + ", qte=" + qte + ", etat=" + etat + ", user="
				+ user + ", fiche=" + fiche + ", priorite=" + priorite + ", piece=" + piece + "]";
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
	
}
