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




public class Feedback extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String Comments = request.getParameter("Comments");

        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}


        try {
        	
            
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nikshan");
            String sql = "INSERT INTO feedback(name, email, Comments) VALUES(?, ?, ?)";
            preparedStatement = con.prepareStatement(sql);

           
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, Comments);

      
            preparedStatement.executeUpdate();

            
            response.sendRedirect("feedbackSuccess.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
