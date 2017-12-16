package com.test.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.test.DTO.TestTable;

public abstract class TestTableDaoAbstract {
	private DataSource dataSource;
	
	public void add(TestTable testTable) throws ClassNotFoundException, SQLException{
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("insert into testTable values(?,?) ");
		
		ps.setString(1, testTable.getId());
		ps.setString(2, testTable.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	public TestTable get(String id) throws ClassNotFoundException, SQLException{
		
		Connection c = getConnection();
		PreparedStatement ps 
			= c.prepareStatement("select * from testTable where id = ?");
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		
		rs.next();
		
		TestTable test = new TestTable();
		test.setId(rs.getString("id"));
		test.setPassword(rs.getString("password"));
		
		
		ps.close();
		rs.close();
		c.close();
		
		return test;
			
	}	
	public abstract Connection getConnection() throws ClassNotFoundException, SQLException; 
}
