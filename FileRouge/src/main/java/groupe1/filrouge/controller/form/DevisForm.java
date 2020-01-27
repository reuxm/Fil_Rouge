package groupe1.filrouge.controller.form;



public class DevisForm {
	private Integer id;
	

	private String dateCreation;
	
	private Boolean etat = false;
	
	private Integer user;
	
	private Integer vehicule;
	
	private Integer client;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
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

	public Integer getVehicule() {
		return vehicule;
	}

	public void setVehicule(Integer vehicule) {
		this.vehicule = vehicule;
	}

	public Integer getClient() {
		return client;
	}

	public void setClient(Integer client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "DevisForm [id=" + id + ", dateCreation=" + dateCreation + ", etat=" + etat + ", user=" + user
				+ ", vehicule=" + vehicule + ", client=" + client + "]";
	}
	
	
}
