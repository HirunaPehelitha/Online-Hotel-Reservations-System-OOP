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

public class Feedbackupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Feedbackupdate() {
        super();}
       
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String Comments=request.getParameter("Comments");
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nikshan");
			
			String query = "UPDATE feedback SET name=?,Comments=? WHERE email=? ";
			PreparedStatement pst=con.prepareStatement(query);
			
			 pst.setString(1, name);
	         
	         pst.setString(2,Comments);
	         pst.setString(3, email);
			 
	         int rowsUpdated = pst.executeUpdate();
	         
	         if (rowsUpdated > 0) {
                 response.sendRedirect("Feedbackpage");
             } else {
                 response.getWriter().write("Error in update task ");
             }
			  
	         request.getRequestDispatcher("editFeedback.jsp").forward(request, response);       
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
         catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}


}