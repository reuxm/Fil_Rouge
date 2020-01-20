package groupe1.filrouge.controller.form;

import javax.validation.constraints.NotEmpty;

public class ClientForm {
	private Integer id;
	@NotEmpty 
	private String name;
	
	@NotEmpty
	private String firstname;
	
	@NotEmpty
	private String adresse;
	
	@NotEmpty
	private String codePostal;
	
	@NotEmpty
	private String ville;
	
	@NotEmpty
	private String telephone;
	
	@NotEmpty
	private String mobile;

	
	private String cloturer="false";
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCloturer() {
		return cloturer;
	}

	public void setCloturer(String cloturer) {
		this.cloturer = cloturer;
	}
	
}
