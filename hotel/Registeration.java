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




public class Registeration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String UserName = request.getParameter("UserName");
        String password = request.getParameter("password");

        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}


        try {
        	
            
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nikshan");
            String sql = "INSERT INTO users(email, UserName, password) VALUES(?, ?, ?)";
            preparedStatement = con.prepareStatement(sql);

           
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, UserName);
            preparedStatement.setString(3, password);

      
            preparedStatement.executeUpdate();

            
            response.sendRedirect("login.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
