package Bai1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private static String DB_URL = "jdbc:mysql://localhost:3306/qlsp";
	private static String USER_NAME = "root";
	private static String PASSWORD = "";
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("Connect successfully!");
		} catch (Exception ex) {
			System.out.println("Connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
}
