package edu.jspiders.thirdstepdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class IssueSQLQueryDemo {
	public static void main(String[] args) 
	{
		try 
		{
			//1. load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. get the Connection via Driver
			String dburl = "jdbc:mysql://localhost:3306/hejm15_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);
			
			//3. Issue SQl Query via Connection
			String query = "insert into student_info values(5,'abc','def','ghi')";
			Statement stmt = con.createStatement();
			int count = stmt.executeUpdate(query);
			
			//4.process the result returned by sql query
			System.out.println(" no of rows affected is "+count);
			
			
			stmt.close();
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
