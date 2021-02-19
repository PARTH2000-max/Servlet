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
	
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String roll_no=req.getParameter("rollno");
		String enroll_no=req.getParameter("enrollno");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		String city=req.getParameter("city");
		
		System.out.println(fname.length());
		
		String url="jdbc:mysql://localhost:3306/java_prac";
		String user="root";
		String pass="Dinesh@9725";
		Connection conn;
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded.");
			conn=DriverManager.getConnection(url, user, pass);
			System.out.println("DataBase Connected..");
									
			String query2="INSERT INTO User (rollno,enrollno,FirstName, LastName, Email,city)\n"+
						"VALUES(?,?,?,?,?,?)";
			
			
			PreparedStatement prep;
			int i=0;
			PrintWriter write=resp.getWriter();	
			resp.setContentType("text/html"); 
			
			prep=conn.prepareStatement(query2);
			
			prep.setString(3,fname);
			prep.setString(4,lname);
			prep.setString(5,email);
			prep.setString(6,city);
								
			if(!roll_no.isEmpty() && !enroll_no.isEmpty() &&!fname.isEmpty() && !lname.isEmpty() && !email.isEmpty() && !city.isEmpty()) {
				prep.setInt(1,Integer.parseInt(roll_no));
				prep.setInt(2,Integer.parseInt(enroll_no));
				i=prep.executeUpdate();
				System.out.println('\n');
				System.out.println("Number of records inserted : "+i);
				 				
				write.println("<p>"+fname+" "+lname+" User registered successfully..</p>");
				
			}else {


				write.println("<script type=\"text/javascript\">");
				write.println("alert('Enter User details');");
				write.println("location='index.html';");
				write.println("</script>");
			}
			
			
			
			
		    
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}
	
	
	

}
