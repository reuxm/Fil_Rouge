package groupe1.filrouge.controller.form;

import javax.validation.constraints.NotEmpty;

public class FicheFormUpdate {

	private String id;

	private String description;

	@NotEmpty
	private String priorite;
	
	private String cloturer;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getCloturer() {
		return cloturer;
	}

	public void setCloturer(String cloturer) {
		this.cloturer = cloturer;
	}

	@Override
	public String toString() {
		return "FicheFormUpdate [id=" + id + ", description=" + description + ", priorite=" + priorite + ", cloturer="
				+ cloturer + "]";
	}

	
}
