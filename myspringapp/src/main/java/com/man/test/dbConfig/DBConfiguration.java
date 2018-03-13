package com.man.test.dbConfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfiguration {

	public Connection getDBConnection() {
		Connection con =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studDB", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
