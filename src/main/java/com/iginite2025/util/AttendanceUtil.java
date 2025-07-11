package com.iginite2025.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AttendanceUtil {
	final static String JDBC_DRIVER = "org.h2.Driver";
	static {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		final String JDBC_URL = "jdbc:h2:tcp://localhost/D:/h2-db/learn";
		final String JDBC_USERNAME = "jacob";
		final String JDBC_PASSWORD = "jacob";
		return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
	}
}
