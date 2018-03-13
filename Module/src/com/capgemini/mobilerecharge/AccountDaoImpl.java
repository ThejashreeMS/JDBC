package com.capgemini.mobilerecharge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class AccountDaoImpl implements AccountDao {
	public Account getAccountDetails(String id)
	{
		PreparedStatement stmt=null;
		Connection con=null;
		ResultSet rs=null;
		String aid=null;
		String atype=null;
		String cname=null;
		double abal=0;
		try {
			java.sql.Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			FileReader fr=null;
			try {
				fr = new FileReader("D:/dbprop/db.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Properties prop = new Properties();
			try {
				prop.load(fr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String dburl="jdbc:mysql://localhost:3306/caps50_db";
			con=DriverManager.getConnection(dburl,prop);

			String query="select * from account where account_id=?";
			stmt=con.prepareStatement(query);
			stmt.setString(1,id);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				aid=rs.getString(1);
				atype=rs.getString(2);
				cname=rs.getString(3);
				abal=rs.getInt(4);
				System.out.println("Account Id: "+aid);
				System.out.println("Customer Name: "+cname);
				System.out.println("Account Type: "+atype);
				System.out.println("Balance: "+abal);
			}
			else{
				System.out.println("This account id does not exist");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)
					rs.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Account ac=new Account();
		ac.accSet(aid,atype,cname,abal);
		return ac;
	}
	public double rechargeAccount(String id,double amt)
	{
		PreparedStatement stmt=null;
		Connection con=null;
		ResultSet rs=null;
		double abal=0;
		try {
			java.sql.Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			FileReader fr=null;
			try {
				fr = new FileReader("D:/dbprop/db.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Properties prop = new Properties();
			try {
				prop.load(fr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String url="jdbc:mysql://localhost:3306/caps50_db";
			con=DriverManager.getConnection(url,prop);

			String query="update account set acc_balance=acc_balance+? where account_id=?";
			stmt=con.prepareStatement(query);
			stmt.setString(2,id);
			stmt.setDouble(1,amt);
			int res=stmt.executeUpdate();
			if(res>0)
			{
				System.out.println("Your account has been successfully recharged with "+amt+" Rs");
				String query1="select * from account where account_id=?";
				stmt=con.prepareStatement(query1);
				stmt.setString(1,id);
				rs=stmt.executeQuery();
				if(rs.next())
				{
					abal=rs.getInt("acc_balance");
				}
			}
			else{
				System.out.println("This account id does not exist");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)
					rs.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return abal;	
	}
}
