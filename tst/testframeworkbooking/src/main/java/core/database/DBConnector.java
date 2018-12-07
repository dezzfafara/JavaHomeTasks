package core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		TripData tripData = new TripData();
		tripData.setDestination(resultSet.getString(1));
		tripData.setDaysFrom(resultSet.getInt(2));
		tripData.setDaysTill(resultSet.getInt(3));
		tripData.setRooms(resultSet.getInt(4));
		tripData.setAdults(resultSet.getInt(5));
		tripData.setChildren(resultSet.getInt(6));
		return tripData;
	}

	public TripData getTripData(String connectionUrl, String login, String password, String sqlQuery)
			throws SQLException {
		return getTrip(getResultSet(connectionUrl, login, password, sqlQuery));
	}

}
