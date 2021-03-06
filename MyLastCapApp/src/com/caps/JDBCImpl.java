package com.caps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.caps.dto.Person;

public class JDBCImpl {
	public boolean insertDetails(Person p){
		FileReader fr=null;
		try {
			fr = new FileReader("D:/dbprop/db.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fr);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//2. get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db";
			con = DriverManager.getConnection(dbUrl,prop);
			
			//3. Issue the SQL query via connection
			String query1 = "INSERT into person_info values(?,?,?)";
			pstmt = con.prepareStatement(query1);
			pstmt.setInt(1, p.getRegno());
			pstmt.setString(2, p.getFname());
			pstmt.setString(3, p.getLname());
			int count1=pstmt.executeUpdate();
			String query2="INSERT into person_otherinfo values(?,?,?)";
			pstmt=con.prepareStatement(query2);
			pstmt.setInt(1, p.getRegno());
			pstmt.setString(2, p.getPassword());
			pstmt.setString(3, p.getType());
			int count2=pstmt.executeUpdate();
			if(count1>0&&count2>0)
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}
}
