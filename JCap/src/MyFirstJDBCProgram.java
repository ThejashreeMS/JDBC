import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class MyFirstJDBCProgram {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter your UserID: ");
		int regno=Integer.parseInt(in.nextLine());
		System.out.println("Enter your password: ");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			// 1. Load the Driver
			java.sql.Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			// 2. Get the db connection via driver
			
			String dbUrl="jdbc:mysql://localhost:3306/caps50_db?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			
			// 3. Issue the SQL query via connection
			
			String query= "INSERT INTO person_info values(?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, regno);
			pstmt.setString(2, fname);
			pstmt.setString(3, lname);
			
			int count=pstmt.executeUpdate();
			
			// 4. Process the results
			
			if(count>0)
			{
				System.out.println("Data inserted successfully");
			}
			else
			{
				System.out.println("Failed to insert data");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			
			// 5. Closing all the JDBC Objects
			
			try {
				if(pstmt!=null)
				{
					pstmt.close();
				}
				if(con !=null)
				{
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
