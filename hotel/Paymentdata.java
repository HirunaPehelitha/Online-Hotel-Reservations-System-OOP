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


public class Paymentdata extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    

    public Paymentdata() {
		super();}
		
	



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		ArrayList<Payments> payList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "nikshan");

            String query = "SELECT * FROM payment"; 
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String userName = rs.getString("userName");
                String paymentEmail = rs.getString("paymentEmail"); 
                String country = rs.getString("country");
                String city = rs.getString("city");
                String cardtype = rs.getString("cardtype"); 
                String cardNumber = rs.getString("cardNumber");
                String cardExp = rs.getString("cardExp");
                String cardCVV = rs.getString("cardCVV"); 
                
                
                Payments p = new Payments(userName, paymentEmail, country,city, cardtype, cardNumber,cardExp, cardCVV);
                payList.add(p);
            }

            System.out.println("Number of users retrieved: " + payList.size());

            request.setAttribute("PayList", payList);
            request.getRequestDispatcher("payementData.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
           
        }
    }
}
