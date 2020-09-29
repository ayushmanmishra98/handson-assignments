package com.hsbc.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.derby.jdbc.ClientDriver;

public class DBUtility {
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		Class.forName(ClientDriver.class.getName());
		//Class.forName("org.apache.derby.jdbc.ClientDriver");//Same as above
		//2.Establish connection
		Connection connection=DriverManager.getConnection("jdbc:derby://localhost:1527/mydb","ayushman","ayushman123");
		return connection;
	}
}
