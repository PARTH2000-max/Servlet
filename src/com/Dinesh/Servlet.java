package com.Dinesh;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class Servlet extends  HttpServlet{

	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		
		System.out.println(fname.length());
		
		String url="jdbc:mysql://localhost:3306/java";
		String user="root";
		String pass="Dinesh@9725";
		Connection conn;
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded.");
			conn=DriverManager.getConnection(url, user, pass);
			System.out.println("DataBase Connected..");
									
			String query2="INSERT INTO User (FirstName, LastName, Email,Contact)\n"+
						"VALUES(?,?,?,?)";
			
			
			PreparedStatement prep;
			int i=0;
			PrintWriter write=resp.getWriter();	
			resp.setContentType("text/html"); 
			
			prep=conn.prepareStatement(query2);
			prep.setString(1,fname);
			prep.setString(2,lname);
			prep.setString(3,email);
			prep.setString(4,mobile);
								
			if(!fname.isEmpty() && !lname.isEmpty() && !email.isEmpty() && !mobile.isEmpty()) {
				i=prep.executeUpdate();
				System.out.println('\n');
				System.out.println("Number of records inserted : "+i);
				 				
				write.println("<p>"+fname+" "+lname+" User registered successfully..</p>");
				
			}else {
				resp.sendRedirect("index.html");
				write.println("<p> User Not registered ..</p>");
			}
			
			
			
			
		    
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}
	
	
	

}
