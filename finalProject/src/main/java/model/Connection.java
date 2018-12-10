package model;

public class Connection {
	private String url;
	private String login;
	private String password;
	private String query;

	public Connection(String url, String login, String password, String query) {
		this.url = url;
		this.login = login;
		this.password = password;
		this.query = query;
	}

	public String getUrl() {
		return url;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getQuery() {
		return query;
	}

}
