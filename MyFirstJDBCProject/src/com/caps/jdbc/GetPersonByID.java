package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class GetPersonByID {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter reg no");
		int regno=sc.nextInt();
		FileReader fr = new FileReader("D:/dbprop/db.properties");
		Properties prop = new Properties();
		prop.load(fr);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			//2. get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db";
			con = DriverManager.getConnection(dbUrl,prop);
			
			//3. Issue the SQL query via connection
			String query = "SELECT * FROM person_info where regno=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, regno);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				int regno1=rs.getInt("regno");
				String fname=rs.getString("firstname");
				String lname=rs.getString("lastname");
				System.out.println(regno1+" "+fname+" "+lname);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			con.close();
			pstmt.close();
		}
	}
}