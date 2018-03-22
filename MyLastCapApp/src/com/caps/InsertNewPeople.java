package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dto.Person;

public class InsertNewPeople extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	PrintWriter pw=resp.getWriter();
	resp.setContentType("text/html");
	int regno=(Integer.parseInt(req.getParameter("regno")));
	String fname=req.getParameter("fname");
	String lname=req.getParameter("lname");
	String password=req.getParameter("pwd");
	String type=req.getParameter("type");
	Person p=new Person();
	p.setFname(fname);
	p.setLname(lname);
	p.setRegno(regno);
	p.setPassword(password);
	p.setType(type);
	
	JDBCImpl ji=new JDBCImpl();
	boolean res=ji.insertDetails(p);
	if(res)
		pw.print("<h2>Data insertion successfull</h2>");
	else
		pw.print("<h2>Data insertion failed</h2>");
}
}
