package dataSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {//
	// attributes
	public static String url = "jdbc:mysql://localhost:3306/thituyensinh?useSSL=false";
	public static String driver = "com.mysql.jdbc.Driver";
	public static String user = "root";
	public static String pass = "2261Jsa5w@#$%";
	public static Connection connect;

	// open connect
	public static Connection open() {

		try {
			if (connect == null || connect.isClosed()) {
				Class.forName(driver);
				connect = DriverManager.getConnection(url, user, pass);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return connect;
	}

	// close connection
	public static void close(Connection connect) {
		try {
			if (connect != null) {
				connect.close();
				connect = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
