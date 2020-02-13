package groupe1.filrouge.controller.form;

public class UserForm {

	private Integer id;
	
	private String nom;

	private String prenom;

	private String login;
	
	private String pass1;
	
	private String pass2;
	
	private boolean[] profils = new boolean[5];
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public boolean[] getProfils() {
		return profils;
	}

	public void setProfils(boolean[] profils) {
		this.profils = profils;
	}

}
