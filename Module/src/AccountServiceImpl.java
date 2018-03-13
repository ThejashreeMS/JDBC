import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class AccountServiceImpl implements AccountService{

	@Override
	public Account getAccountDetails(String accountID) {
		FileReader fr=null;
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
		ResultSet rs=null;
		try {
			//2. get the DB connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/caps50_db";
			con = DriverManager.getConnection(dbUrl,prop);
			
			//3. Issue the SQL query via connection
			String query = "SELECT * FROM ACCOUNT where ACCOUNT_ID=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, accountID);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				int acno=rs.getInt("ACCOUNT_ID");
				String atype=rs.getString("ACCOUNT_TYPE");
				String cname=rs.getString("CUSTOMER_NAME");
				int bal=rs.getInt("ACC_BALANCE");
				Account ac=new Account();
				ac.setAccountBalance(bal);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
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
		return ac;
	}

	@Override
	public int rechargeAccoun(String accountID, double rechargeAmount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
