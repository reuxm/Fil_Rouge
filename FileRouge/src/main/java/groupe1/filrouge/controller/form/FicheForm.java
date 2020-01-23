package groupe1.filrouge.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

public class FicheForm {

	private int id;

	private String description;

	@NotEmpty( message="veuillez indiquer une priorite" )
	private String priorite;

	@NotEmpty( message="la fiche n'est pas liee a un client" )
	private String client;
	
	@PositiveOrZero( message="Le prix ne peux pas être négatif" )
	private Float prix;
	
	@PositiveOrZero( message="La TVA ne peux pas être négative" )
	private Float tva;
	
	private String cloturer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriorite() {
		return priorite;
	}

	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public Float getTva() {
		return tva;
	}

	public void setTva(Float tva) {
		this.tva = tva;
	}

	public String getCloturer() {
		return cloturer;
	}

	public void setCloturer(String cloturer) {
		this.cloturer = cloturer;
	}
	
	
}
