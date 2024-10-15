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


public class bookingdata extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    

 




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		ArrayList<Book> BookingList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "nikshan");

            String query = "SELECT * FROM booking"; 
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String Name = rs.getString("Name");
                String Email = rs.getString("Email"); 
                String CheckIn = rs.getString("CheckIn");
                String CheckOut = rs.getString("CheckOut"); 
                String Guests = rs.getString("Guests");
                String RoomType = rs.getString("RoomType"); 
                String Rooms = rs.getString("Rooms");
                String loyalty = rs.getString("loyalty"); 
          
                
                Book booked = new Book(Name, Email, CheckIn,CheckOut, Guests, RoomType,Rooms, loyalty );
                BookingList.add(booked);
            }

            System.out.println("Number of users retrieved: " + BookingList.size());

            request.setAttribute("BookList", BookingList);
            request.getRequestDispatcher("Bookingdata.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
           
        }
    }
}
