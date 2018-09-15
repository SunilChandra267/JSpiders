package edu.jspiders.myfirstjdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class MyFirstJDBCProgram {
	
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			
			//1. Load the Driver
//			Driver d = new Driver();
//			DriverManager.registerDriver(d);
			
			Class.forName("com.mysql.jdbc.Driver");
			//2. Get the DB connection via Driver
			String dburl = 
	"jdbc:mysql://localhost:3306/hejm15_db?user=root&password=root";
			 con = DriverManager.getConnection(dburl);
			
			
			//3. Issue SQL Queries via Connection
			String query = "select * from student_info";
			 stmt = con.createStatement();
			 rs = stmt.executeQuery(query);
			
			
			//4. Process the results returned by Sql Query
			while(rs.next())
			{
				int regno = rs.getInt("regno");
				String fname = rs.getString("first_name");
				String mname = rs.getString("middle_name");
				String lname = rs.getString("last_name");
				
				System.out.println(regno);
				System.out.println(fname);
				System.out.println(mname);
				System.out.println(lname);
				System.out.println("===========================");
			}
			
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			//5. close all the JDBC objects
			try 
			{
				con.close();
				stmt.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}//end of finally
	}//end of main
}//end of class
