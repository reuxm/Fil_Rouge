package groupe1.filrouge.entity;

import com.fasterxml.jackson.annotation.*;

public class LoginInfo {
	
	@JsonProperty("login")
	private String login;
	
	@JsonProperty("pwd")
	private String pwd;
	
	@JsonCreator
	public LoginInfo( @JsonProperty("login") String login, @JsonProperty("pwd") String pwd ) {
		this.login = login;
		this.pwd = pwd;
	}

	@JsonProperty("login")
	public String getLogin() {
		return login;
	}

	@JsonProperty("login")
	public void setLogin(String login) {
		this.login = login;
	}

	@JsonProperty("pwd")
	public String getPwd() {
		return pwd;
	}

	@JsonProperty("pwd")
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
