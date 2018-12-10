package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import builder.CredentialsBuilder;
import model.Credentials;

public class SQLConnector {

	private ResultSet getResultSet(String connectionUrl, String login, String password, String sqlQuery)
			throws SQLException {
		Connection connection = DriverManager.getConnection(connectionUrl, login, password);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sqlQuery);
		resultSet.next();
		return resultSet;
	}

	private Credentials getCredentials(ResultSet resultSet) throws SQLException {
		Credentials credentials = new CredentialsBuilder().setLogin(resultSet.getString(1))
				.setPassword(resultSet.getString(2)).setDomain(resultSet.getString(3)).build();
		return credentials;
	}

	public Credentials getCredentialsData(String connectionUrl, String login, String password, String sqlQuery)
			throws SQLException {
		return getCredentials(getResultSet(connectionUrl, login, password, sqlQuery));
	}

}