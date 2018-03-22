import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/updateStock")
public class UpdateStock extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter pw=resp.getWriter();
	resp.setContentType("text/html");
	String provider=req.getParameter("provider");
	int aqty=(Integer.parseInt(req.getParameter("aqty")));
	int cqty=(Integer.parseInt(req.getParameter("cqty")));
	Connection con=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	FileReader fr=new FileReader("D:/dbprop/db.properties");
	Properties prop=new Properties();
	prop.load(fr);
	String dburl="jdbc:mysql://localhost:3306/caps50_db";
	try {
		con=DriverManager.getConnection(dburl,prop);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	//issue query
	String query="UPDATE LPGStock set AvQty=AvQty-? where UpdatedBy=?";
	try {
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setInt(1, cqty);
		pstmt.setString(2, provider);
		int rs=pstmt.executeUpdate();
		if(rs>0)
		{
			pw.println("<h3>Stock Updated</h3>");
			
		}
		else
		{
			pw.println("<h3>Stock could not be Updated</h3>");
		}
		pw.println("<a href=http://localhost:8080/LPGStock/index.html>Go To Home</a>");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}	
}
}
