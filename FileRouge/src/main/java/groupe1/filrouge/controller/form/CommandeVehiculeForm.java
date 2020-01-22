package groupe1.filrouge.controller.form;


public class CommandeVehiculeForm {

	private Integer id;

	private Integer id_devis;

	private Boolean etat;

	private String dateCreation;

	private String dateCloture;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_devis() {
		return id_devis;
	}

	public void setId_devis(Integer id_devis) {
		this.id_devis = id_devis;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDateCloture() {
		return dateCloture;
	}

	public void setDateCloture(String dateCloture) {
		this.dateCloture = dateCloture;
	}
	
	

}
