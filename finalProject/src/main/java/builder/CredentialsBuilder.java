package builder;

import model.Credentials;

public class CredentialsBuilder {
	private String login;
	private String password;
	private String domain;

	public CredentialsBuilder setLogin(String login) {
		this.login = login;
		return this;
	}

	public CredentialsBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public CredentialsBuilder setDomain(String domain) {
		this.domain = domain;
		return this;
	}

	public Credentials build() {
		return new Credentials(login, password, domain);
	}
}
