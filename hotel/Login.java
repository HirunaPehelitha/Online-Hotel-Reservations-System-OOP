package hotel;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nikshan");
		
		String query= "SELECT *  FROM users WHERE  email=? AND password=?";
		PreparedStatement pst=con.prepareStatement(query);
		 pst.setString(1, email);
		 pst.setString(2, password);
		 
		    
        
		 
		  ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {  
                System.out.println("Login successful");
                response.sendRedirect("home.jsp");
            } else {
                System.out.println("Invalid credentials");
                response.sendRedirect("error.jsp");
            }
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
     catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	
	
	}
	
	

}
