package groupe1.filrouge.controller.form;

import javax.validation.constraints.NotEmpty;

public class PieceForm {
	private Integer id;
	
	@NotEmpty
	private String libelle;
	
	@NotEmpty
	private String qte;
	
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

	public String getQte() {
		return qte;
	}

	public void setQte(String qte) {
		this.qte = qte;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

}
