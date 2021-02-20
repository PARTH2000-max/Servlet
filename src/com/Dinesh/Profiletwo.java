package com.Dinesh;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profiletwo")
public class Profiletwo extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String opt=req.getParameter("option");
		String value=req.getParameter("num");
		
		String url="jdbc:mysql://localhost:3306/java_prac_new";
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
			
			System.out.println(opt+" "+value);
			PreparedStatement prep;
			ResultSet rs;
			if(!value.isEmpty()) {
				if(opt.equals("enroll")) {
					
					String qenroll="select * from User where enrollno=?";
					prep=conn.prepareStatement(qenroll);
					prep.setInt(1,Integer.parseInt(value));
					rs=prep.executeQuery();
					
					if(rs.next()) {
						
						req.setAttribute("rnum", String.valueOf(rs.getInt("rollno")));
						req.setAttribute("enum", String.valueOf(rs.getInt("enrollno")));
						req.setAttribute("fname", rs.getString("FirstName"));
						req.setAttribute("lname", rs.getString("LastName"));
						req.setAttribute("email", rs.getString("Email"));
						req.setAttribute("city", rs.getString("city"));
						req.getRequestDispatcher("WEB-INF/jsp/profile.jsp").include(req, resp);
						
					}else {
						
						
						write.println("<script type=\"text/javascript\">");
//						write.println("alert('");
						write.println("alert('"+opt.toUpperCase()+" number "+value+" Not Found');");
						write.println("location='Finduser-2.html';");
						write.println("</script>");
					}
					
					
				}else {
					String qenroll="select * from User where rollno=?";
					prep=conn.prepareStatement(qenroll);	
					prep.setInt(1,Integer.parseInt(value));
					rs=prep.executeQuery();
					
					
					if(rs.next()) {
						req.setAttribute("rnum", String.valueOf(rs.getInt("rollno")));
						req.setAttribute("enum", String.valueOf(rs.getInt("enrollno")));
						req.setAttribute("fname", rs.getString("FirstName"));
						req.setAttribute("lname", rs.getString("LastName"));
						req.setAttribute("email", rs.getString("Email"));
						req.setAttribute("city", rs.getString("city"));
						req.getRequestDispatcher("WEB-INF/jsp/profile.jsp").include(req, resp);
					}else {
						
						
						write.println("<script type=\"text/javascript\">");
//						write.println("alert('");
						write.println("alert('"+opt.toUpperCase()+" number "+value+" Not Found');");
						write.println("location='Finduser-2.html';");
						write.println("</script>");
					}
						
				}
			}else {
				
				
				write.println("<script type=\"text/javascript\">");
				write.println("alert('Enter Number');");
				write.println("location='Finduser-2.html';");
				write.println("</script>");
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	

}
}
	
