package core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import core.builder.TripData;
import core.builder.TripDataBuilder;

public class DBConnector {

	private ResultSet getResultSet(String connectionUrl, String login, String password, String sqlQuery)
			throws SQLException {
		Connection connection = DriverManager.getConnection(connectionUrl, login, password);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sqlQuery);
		resultSet.next();
		return resultSet;
	}

	private TripData getTrip(ResultSet resultSet) throws SQLException {
		TripData tripData = new TripDataBuilder().setDestination(resultSet.getString(1))
				.setDaysFrom(resultSet.getInt(2)).setDaysTill(resultSet.getInt(3)).setRooms(resultSet.getInt(4))
				.setAdults(resultSet.getInt(5)).setChildren(resultSet.getInt(6)).build();
		return tripData;
	}

	public TripData getTripData(String connectionUrl, String login, String password, String sqlQuery)
			throws SQLException {
		return getTrip(getResultSet(connectionUrl, login, password, sqlQuery));
	}

}
