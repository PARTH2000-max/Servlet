package com.Dinesh;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class Profile extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String e=req.getParameter("email");
//		String p=req.getParameter("pass");
		System.out.println(e);
		String url="jdbc:mysql://localhost:3306/java";
		String user="root";
		String pass="Dinesh@9725";
		Connection conn;
		
		PrintWriter write=resp.getWriter();	
		resp.setContentType("text/html"); 
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded.");
			conn=DriverManager.getConnection(url, user, pass);
			System.out.println("DataBase Connected..");
			
			PreparedStatement prep=conn.prepareStatement("Select * from User where Email=?");
			prep.setString(1, e);
			
			ResultSet rs=prep.executeQuery();
			
			
			System.out.println(rs.getFetchSize());

			if(rs.next()) {
				
				req.setAttribute("id",String.valueOf(rs.getInt("Id")));
				req.setAttribute("fname", rs.getString("FirstName"));
				req.setAttribute("lname", rs.getString("LastName"));
				req.setAttribute("email", rs.getString("Email"));
				req.setAttribute("contact", rs.getString("Contact"));
				req.getRequestDispatcher("WEB-INF/jsp/profile.jsp").include(req, resp);
				
				
				
				
			}else {
				write.println("User with Email "+e+" doesn't exists..");
				req.getRequestDispatcher("Finduser.html").include(req, resp);

			}
		
		
		
	}catch (Exception a) {
		// TODO: handle exception
		a.printStackTrace();
	}
	
	
	
	
}
	
	
	
	
}
