package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnecter {

	public static Connection getConnection() {

		Connection connection = null;

		try {
			String userName = "root";
			String password = "1234";
			String url = "jdbc:mysql://localhost:3306";
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url, userName, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}