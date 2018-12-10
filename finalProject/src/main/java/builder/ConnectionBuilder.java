package builder;

import model.Connection;

public class ConnectionBuilder {
	private String url;
	private String login;
	private String password;
	private String query;

	public ConnectionBuilder setUrl(String url) {
		this.url = url;
		return this;
	}

	public ConnectionBuilder setLogin(String login) {
		this.login = login;
		return this;
	}

	public ConnectionBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public ConnectionBuilder setQuery(String query) {
		this.query = query;
		return this;
	}

	public Connection build() {
		return new Connection(url, login, password, query);
	}
}
