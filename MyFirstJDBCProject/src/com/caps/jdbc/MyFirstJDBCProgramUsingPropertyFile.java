package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class MyFirstJDBCProgramUsingPropertyFile {
	public static void main(String[] args) throws Exception {
		
		FileReader fr = new FileReader("D:/dbprop/db.properties");
		Properties prop = new Properties();
		prop.load(fr);
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter you regno: ");
		int regno = Integer.parseInt(in.nextLine());
		
		System.out.println("Enter your First name: ");
		String fname = in.nextLine();
		
		System.out.println("Enter your Last Name: ");
		String lname = in.nextLine();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			 //1. Load the Driver
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
//			java.sql.Driver ref = 
//					(java.sql.Driver)Class
//					.forName("com.mysq.jdbc.Driver")
//					.newInstance();
			
			//2. get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db";
			con = DriverManager.getConnection(dbUrl,prop);
			
			//3. Issue the SQL query via connection
			String query = "INSERT INTO person_info values(?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, regno);
			pstmt.setString(2, fname);
			pstmt.setString(3, lname);
			
			int count = pstmt.executeUpdate();
			
			//4. Process the results
			if(count > 0) {
				System.out.println("Data Inserted Successfully");
			}else {
				System.out.println("Failed to Insert Data");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//5. Closing all the JDBC Objects
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
