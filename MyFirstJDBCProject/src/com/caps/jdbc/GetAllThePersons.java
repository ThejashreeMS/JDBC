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

public class GetAllThePersons {
	public static void main(String[] args) throws Exception {
		
		FileReader fr = new FileReader("D:/dbprop/db.properties");
		Properties prop = new Properties();
		prop.load(fr);
		Connection con = null;
		Statement stmt = null;
		ResultSet rs=null;
		try {
			//2. get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db";
			con = DriverManager.getConnection(dbUrl,prop);
			
			//3. Issue the SQL query via connection
			String query = "SELECT * FROM person_info";
			stmt = con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next())
			{
				int regno=rs.getInt("regno");
				String fname=rs.getString("firstname");
				String lname=rs.getString("lastname");
				System.out.println(regno+" "+fname+" "+lname);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			con.close();
			stmt.close();
		}
	}
}