package groupe1.filrouge.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class PieceForm {
	private Integer id;
	
	private String libelle;
	
	@PositiveOrZero(message = "La quantité doit être positive !")
	private Integer qte;
	
	@NotEmpty
	private String dateCreation;

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

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

}
