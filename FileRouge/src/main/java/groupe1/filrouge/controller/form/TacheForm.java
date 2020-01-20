package groupe1.filrouge.controller.form;

import javax.validation.constraints.NotEmpty;

public class TacheForm {
	
	private Integer id;
	
	@NotEmpty 
	private String commentaire;
	

	private Integer qte;
	
	private Boolean etat;
	

	private Integer user;
	

	private Integer fiche;
	

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
	
	
	
	
}