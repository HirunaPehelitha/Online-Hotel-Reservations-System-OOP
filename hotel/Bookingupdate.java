package hotel;



import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Bookingupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Bookingupdate() {
        super();}
       
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String Name=request.getParameter("Name");
		String Email=request.getParameter("Email");
		String CheckIn=request.getParameter("CheckIn");
		String CheckOut=request.getParameter("CheckOut");
		String Guests=request.getParameter("Guests");
	
		String RoomType=request.getParameter("RoomType");
		String Rooms=request.getParameter("Rooms");
		String loyalty=request.getParameter("loyalty");
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nikshan");
			
			String query = "UPDATE booking SET Name=?,Email=?,CheckIn=?,CheckOut=?,Guests=?,RoomType=?,Rooms=?,loyalty=? WHERE Email=? ";
			PreparedStatement pst=con.prepareStatement(query);
			
			 pst.setString(1, Name);
	         pst.setString(2, Email);
	         pst.setString(3,CheckIn);
	         pst.setString(1, CheckOut);
	         pst.setString(2, Guests);
	         pst.setString(3,RoomType);
	         pst.setString(1, Rooms);
	         pst.setString(2, loyalty);
	        
	       
	        
			 
	         int rowsUpdated = pst.executeUpdate();
	         
	         if (rowsUpdated > 0) {
                 response.sendRedirect("#");
             } else {
                 response.getWriter().write("Error in update task ");
             }
			  
	         request.getRequestDispatcher("#").forward(request, response);       
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
         catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}


}