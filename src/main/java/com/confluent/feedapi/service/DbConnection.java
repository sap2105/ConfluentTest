package com.confluent.feedapi.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getDBconnection() {
		Connection con=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/<DATABASE_NAME>","<USERNAME>","<PASSWORD>");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
}
