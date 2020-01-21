package groupe1.filrouge.controller.form;

import javax.validation.constraints.PositiveOrZero;

public class CommandePieceForm {
	private Integer id;
	private Integer id_user;
	private Integer id_piece;
	
	@PositiveOrZero(message = "La quantité doit être positive !")
	private Integer qte;
	
	private String dateCreation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getId_piece() {
		return id_piece;
	}

	public void setId_piece(Integer id_piece) {
		this.id_piece = id_piece;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

}
