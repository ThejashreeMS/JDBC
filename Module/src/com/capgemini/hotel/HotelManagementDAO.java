package com.capgemini.hotel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class HotelManagementDAO {
	public static void ViewStatus(int cid) {
		Scanner scn = new Scanner(System.in);
		FileReader fr = null;
		try {
			fr = new FileReader("D:/dbprop/db.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fr);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 2. get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db";
			con = DriverManager.getConnection(dbUrl, prop);

			// 3. Issue the SQL query via connection
			String query = "SELECT * FROM CustomerDetails where CustID=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			int rno = 0;
			if (rs.next()) {
				String cname = rs.getString("CustName");
				rno = rs.getInt("RoomNo");

				System.out.println("Name of the Customer: " + cname);
				System.out.println("Room No: " + rno);
				String query1 = "SELECT * FROM RoomsDetail where RoomNo=?";
				PreparedStatement pstmt1 = con.prepareStatement(query1);
				pstmt1.setInt(1, rno);
				ResultSet rs1 = pstmt1.executeQuery();
				if (rs1.next()) {

					String rtype = rs1.getString(2);
					System.out.println("Room Type: " + rtype);
					String rstats = rs1.getString(3);
					System.out.println("Booking Status: " + rstats);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void bookRoom(String custname, String cname,String email,String address,long mobile, String rtype, int rno)
	{
		FileReader fr = null;
		try {
			fr = new FileReader("D:/dbprop/db.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fr);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 2. get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db";
			con = DriverManager.getConnection(dbUrl, prop);

			// 3. Issue the SQL query via connection
			String query = "INSERT into CustomerDetails values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			int rp=(int) Math.r;
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			int rno = 0;
	}
}
