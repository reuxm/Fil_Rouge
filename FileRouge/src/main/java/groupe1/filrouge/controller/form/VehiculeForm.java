package groupe1.filrouge.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class VehiculeForm {
	private Integer id;
	
	@NotEmpty
	private String modele;
	
	@PositiveOrZero(message = "La quantité doit être positive !")
	private Integer qte;
	
	private Float prixHT;
	
	@NotEmpty
	private String dateCreation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public Float getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(Float prixHT) {
		this.prixHT = prixHT;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

}
