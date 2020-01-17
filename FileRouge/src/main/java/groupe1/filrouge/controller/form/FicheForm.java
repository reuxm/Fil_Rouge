package groupe1.filrouge.controller.form;

import javax.validation.constraints.NotEmpty;

public class FicheForm {

	private int id;

	private String description;

	@NotEmpty
	private String priorite;

	@NotEmpty
	private String client;

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
	
	
}
