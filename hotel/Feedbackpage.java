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

public class Feedbackpage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Feedbacks> feedbackList = new ArrayList<>();

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "nikshan");

            String query = "SELECT * FROM feedback"; 
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email"); 
                String comments = rs.getString("Comments"); // Changed to lowercase variable

                Feedbacks feeds = new Feedbacks(name, email, comments); // Ensure the constructor exists
                feedbackList.add(feeds);
            }

            System.out.println("Number of feedback retrieved: " + feedbackList.size());

            request.setAttribute("feedbacksList", feedbackList);
            request.getRequestDispatcher("feedbackview.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close resources to avoid memory leaks
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
