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




public class Payment extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    

    public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		
		String userName = request.getParameter("userName");
        String paymentEmail = request.getParameter("paymentEmail");
        String country = request.getParameter("country");
    	String city = request.getParameter("city");
        String cardtype = request.getParameter("cardtype");
        String cardNumber = request.getParameter("cardNumber");
    	String cardExp = request.getParameter("cardExp");
        String cardCVV = request.getParameter("cardCVV");
       

        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}


        try {
        	
            
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nikshan");
            String sql = "INSERT INTO payment(userName, paymentEmail, country,city,cardtype,cardNumber,cardExp,cardCVV) VALUES(?, ?, ?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);

           
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, paymentEmail);
            preparedStatement.setString(3, country);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, cardtype);
            preparedStatement.setString(6, cardNumber);
            preparedStatement.setString(7, cardExp);
            preparedStatement.setString(8, cardCVV);
           

      
            preparedStatement.executeUpdate();

            
            response.sendRedirect("Paymentdata");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
