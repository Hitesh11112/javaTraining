package com.coforge.Day_08_07_2026_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
public class JDBCApp {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Hello World");
		
		//1.Load The Drivers
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		String url = "jdbc:mysql://localhost:3306/empdb";
		String uname = "root";
		String pwd = "19012004Hp@#";
		
		//2.establish connection
		Connection con = DriverManager.getConnection(url, uname, pwd);
		System.out.println("Connection established\n");
		
		//3. create or use statement
		//statement -----select
		String query = "select * from employeesalary";
		Statement statemnet = con.createStatement();
		//PreparedStatement ---- DML queries
		//CallableStatement ---- procedure 
		
		//4. execute query
		ResultSet rs = statemnet.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " 
					+ rs.getString(3) + " " + rs.getDouble(4) 
					+ " " +rs.getDate(5));
		}
		
		// executeQuery -- select()result is set of records), executeUpdate, execute
		// executeUpdate -- dml(an int is returned);
		// execute --boolean value 
	}
}
