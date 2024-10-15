package hotel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Payupdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Payupdate() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String paymentEmail = request.getParameter("paymentEmail");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String cardtype = request.getParameter("cardtype"); // Corrected to match form input name
        String cardNumber = request.getParameter("cardNumber");
        String cardExp = request.getParameter("cardExp");
        String cardCVV = request.getParameter("cardCVV");

        Connection con = null;
        PreparedStatement pst = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "nikshan");

            String query = "UPDATE payment SET userName=?, paymentEmail=?, country=?, city=?, cardtype=?, cardNumber=?, cardExp=?, cardCVV=? WHERE paymentEmail=?";
            pst = con.prepareStatement(query);
            
            // Set parameters
            pst.setString(1, userName);
            pst.setString(2, paymentEmail);
            pst.setString(3, country);
            pst.setString(4, city);
            pst.setString(5, cardtype);
            pst.setString(6, cardNumber);
            pst.setString(7, cardExp);
            pst.setString(8, cardCVV);
            pst.setString(9, paymentEmail); 

            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                response.sendRedirect("Paymentdata"); 
            } else {
                response.getWriter().write("Error in update task.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Database error: " + e.getMessage()); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().write("JDBC Driver not found: " + e.getMessage());
        } finally {
            try {
                if (pst != null) pst.close(); 
                if (con != null) con.close(); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
