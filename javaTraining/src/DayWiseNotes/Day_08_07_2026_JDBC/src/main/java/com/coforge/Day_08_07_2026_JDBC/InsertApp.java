package com.coforge.Day_08_07_2026_JDBC;

import java.sql.*;
import java.time.LocalDate;

public class InsertApp {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/empdb";
		String uname="root";
		String pwd="19012004Hp@#";
		Connection con = DriverManager.getConnection(url,uname,pwd);
		
		String query = "insert into employeesalary values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, 12);
		ps.setString(2, "hiteshPatwal");
		ps.setString(3, "IT");
		ps.setDouble(4, 70000);
		ps.setDate(5, java.sql.Date.valueOf(	LocalDate.now()));
		
		ps.executeUpdate();
		System.out.println("End of the program");
	}
}
