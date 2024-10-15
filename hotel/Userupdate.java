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


public class Userupdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Userupdate() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String userName = request.getParameter("UserName");
        String password = request.getParameter("password");

        Connection con = null;
        PreparedStatement pst = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "nikshan");

            String query = "UPDATE users SET UserName=?, password=? WHERE email=?";
            pst = con.prepareStatement(query);

            pst.setString(1, userName);
            pst.setString(2, password);
            pst.setString(3, email);

            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                response.sendRedirect("Userdata");
            } else {
                request.setAttribute("errorMessage", "Error in update task");
                // Send back to Userupdate.jsp without a redirect
                request.getRequestDispatcher("Userupdate.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            request.getRequestDispatcher("Userupdate.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "JDBC Driver not found: " + e.getMessage());
            request.getRequestDispatcher("Userupdate.jsp").forward(request, response);
        } finally {
            // Ensure resources are closed
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
