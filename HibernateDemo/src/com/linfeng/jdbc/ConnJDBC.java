package com.linfeng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnJDBC {
	public static void connectDB() {
		String jdbcUrl = "jdbc:mysql://localhost:3306/HibernateDB";
		String user = "root";
		String pass = "wlf5165804";
		try {
			System.out.println("connecting to database:"+jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection sucessful");
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		
	}

}
