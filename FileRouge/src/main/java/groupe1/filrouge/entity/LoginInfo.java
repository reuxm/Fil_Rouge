package groupe1.filrouge.entity;

public class LoginInfo {
	
	private String login;
	
	private String pwd;
	
	public LoginInfo( String l, String p ) {
		login = l;
		pwd = p;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
