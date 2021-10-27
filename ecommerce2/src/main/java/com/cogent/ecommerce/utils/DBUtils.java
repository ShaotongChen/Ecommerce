package com.cogent.ecommerce.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {

	@Autowired
	DataSource dataSource;
	
	public DBUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection() {
		
		Connection cn = null;
		try {
			cn = dataSource.getConnection();
			return cn;
			
		} catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return null;
	}
public void closeConnection(Connection connection) {
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
