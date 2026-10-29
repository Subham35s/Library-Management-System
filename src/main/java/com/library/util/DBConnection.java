package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String url = "jdbc:mysql://localhost:3306/library_db?userSSL=false&serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "root";
	
	private static DBConnection instance;
	private Connection connection;
	
	private DBConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, password);
		}catch(ClassNotFoundException e) {
			throw new SQLException("Mysql not found exception", e);
		}
	}	
	public static DBConnection getInstance() throws SQLException {
		if(instance == null || instance.connection.isClosed()) {
			instance = new DBConnection();
		}
		return instance;
	}
	public Connection getConnection() {
		return connection;
	}
}