package com.test.Main;

import java.sql.SQLException;

import com.test.DAO.TestTableDao;
import com.test.DB.ConnectionMaker;
import com.test.DB.DaumConnectionMaker;
import com.test.DTO.TestTable;

public class MainTest {

	public static void main(String [] args) throws ClassNotFoundException, SQLException{
		ConnectionMaker cm = new DaumConnectionMaker();
		
		TestTableDao dao = new TestTableDao(cm);
		
		
		TestTable test = new TestTable();
		test.setId("dongmin1");
		test.setPassword("1234");
		
		dao.add(test);
		
		System.out.println(test.getId()+" 등록 성");
		
		
		TestTable test2 = dao.get(test.getId());
		System.out.println(test2.getPassword());
		
	}
}
