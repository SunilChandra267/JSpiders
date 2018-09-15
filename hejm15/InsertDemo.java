package edu.jspiders.thirdstepdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class InsertDemo {
	public static void main(String[] args) {
		String sid= args[0];
		int id = Integer.parseInt(sid);
		
		String fname = args[1];
		
		String mname = args[2];
		
		String lname = args[3];
		System.out.println(id+" "+fname+" "+mname+" "+lname);
		
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dburl = "jdbc:mysql://localhost:3306/hejm15_db?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);
			
			String query = "insert into student_info values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setString(2, fname);
			pstmt.setString(3, mname);
			pstmt.setString(4, lname);
			int count = pstmt.executeUpdate();
			
			if(count>=1)
			{
				System.out.println("Student data inserted Successfully");
			}
			else {
				System.out.println("not inserted");
			}
			
			
			pstmt.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
