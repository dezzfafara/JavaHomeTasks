package model;

public class Credentials {
	private String login;
	private String password;
	private String domain;

	public Credentials(String login, String password, String domain) {
		this.login = login;
		this.password = password;
		this.domain = domain;
	}

	public String getLogin() {
		return this.login;
	}

	public String getPassword() {
		return this.password;
	}

	public String getDomain() {
		return domain;
	}
}
