package com.test.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaumConnectionMaker implements ConnectionMaker {

	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/efws?useSSL=false"
				,"EFWS" ,"elandFood12!@" );
		
		return c;
	}

}
