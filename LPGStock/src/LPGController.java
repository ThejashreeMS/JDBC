import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getStock")
public class LPGController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int stock;
		String provider, status;
		String location = req.getParameter("location");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		// get jdbc connection
		Connection con = null;
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, resp);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		FileReader fr = new FileReader("D:/dbprop/db.properties");
		Properties prop = new Properties();
		prop.load(fr);
		String dburl = "jdbc:mysql://localhost:3306/caps50_db";
		try {
			con = DriverManager.getConnection(dburl, prop);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// issue query
		String query = "SELECT * from LPGStock where Location=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, location);
			ResultSet rs = pstmt.executeQuery();
			out.println("</br>");
			out.println("<table border=1>");
			out.println("<td>Available Stock</td><td>LPG Provider</td><td>Location</td><td>Show Consumption</td>");
			while (rs.next()) {
				stock = rs.getInt(1);
				provider = rs.getString(3);
				if (stock > 0) {
					status = "Consume Now";
					out.println("<tr>");
					out.println("<td>" + stock + "</td><td>" + provider + "</td><td>" + location + "</td><td><a href="
							+ "http://localhost:8080/LPGStock/updateStock.html?provider=Seva>" + status + "</a></td>");
					out.println("</tr>");
				} else {
					status = "No LPG Stock";
					out.println("<tr>");
					out.println("<td>" + stock + "</td><td>" + provider + "</td><td>" + location + "</td><td>" + status
							+ "</td>");
					out.println("</tr>");
				}

			}
			out.println("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
