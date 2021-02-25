package com.m2iformation.startJdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StartJdbc {

	public static void main(String[] args) {
		
		Properties props = new Properties();

		try(FileInputStream fis = new FileInputStream("conf.properties")){
		    
			props.load(fis);
			
			Class.forName(props.getProperty("jdbc.driver.class"));
			
			String url = props.getProperty("jdbc.url");
			String login = props.getProperty("jdbc.login");
			String password = props.getProperty("jdbc.password");
			Connection connection = DriverManager.getConnection(url, login, password);
			
			//firstInsert(connection);
			
			String req = "SELECT * FROM livre";
			
			try(Statement statement = connection.createStatement()){
				ResultSet rs = statement.executeQuery(req);
				while(rs.next()) {
					System.out.println(rs.getString("isbn"));
				}
			}
			
			
			connection.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void firstInsert(Connection connection) throws SQLException {
		String req = "insert into livre values ('978-2070368228','1984', 'george', 'orwell', 'Gallimard', 1972)";
		
		try (Statement statement =  connection.createStatement() ){
		    statement.executeUpdate(req);
		}
	}

}
