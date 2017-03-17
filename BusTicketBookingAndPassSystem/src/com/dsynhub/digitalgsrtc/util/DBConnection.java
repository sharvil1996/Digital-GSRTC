package com.dsynhub.digitalgsrtc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	static Connection conn=null; 
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/busindicator","root","root");		
			if(conn!=null)
				System.out.println("Connected Whith DB..........");
			else
				System.out.println("Not Connected Whith DB..........");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
