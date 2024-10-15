package hotel;



import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




public class Booking extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Name = request.getParameter("Name");
        String Email = request.getParameter("Email");
        String CheckIn = request.getParameter("CheckIn");
        String CheckOut = request.getParameter("CheckOut");
        String Guests = request.getParameter("Guests");
        String RoomType = request.getParameter("RoomType");
        String Rooms = request.getParameter("Rooms");
        String loyalty = request.getParameter("loyalty");
      
       

        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}


        try {
        	
            
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nikshan");
            String sql = "INSERT INTO booking(Name, Email, CheckIn,CheckOut,Guests,RoomType,Rooms,loyalty) VALUES(?, ?, ?,?, ?, ?,?, ?)";
            preparedStatement = con.prepareStatement(sql);

           
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, Email);
            preparedStatement.setString(3, CheckIn);
            preparedStatement.setString(4, CheckOut);
            preparedStatement.setString(5, Guests);
            preparedStatement.setString(6, RoomType);
            preparedStatement.setString(7, Rooms);
            preparedStatement.setString(8, loyalty);
            

      
            preparedStatement.executeUpdate();

            
            response.sendRedirect("login.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
