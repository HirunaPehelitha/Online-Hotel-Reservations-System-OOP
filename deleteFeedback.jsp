<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Delete Feedback Confirmation</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Are you sure you want to delete this feedback?</h2>
<%
    String feedbackId = request.getParameter("id"); 
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String name = "", email = "", Comments = "";

    try {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "nikshan");
        String query = "SELECT * FROM feedback WHERE ID = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, email);
        rs = ps.executeQuery();

        if (rs.next()) {
        	name = rs.getString("name");
            email = rs.getString("email");
            Comments = rs.getString("Comments");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conn != null) conn.close();
    }
%>

    <div class="alert alert-danger" role="alert">      
        <strong>Name:</strong> <%= name %><br>
        <strong>Email:</strong> <%= email %><br>
        <strong>Review:</strong> <%=Comments %>
    </div>

    <form action="FeedbackDelete" method="post">
        <button type="submit" class="btn btn-danger">Yes, Delete Feedback</button>
        <a href="Adminfeedback,jsp.jsp" class="btn btn-secondary">Cancel</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
