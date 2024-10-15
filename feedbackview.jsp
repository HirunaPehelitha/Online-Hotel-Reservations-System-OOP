<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin Feedback Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Feedback Management</h2>
    
    <div class="text-right mb-3">
        <a href="feedback.jsp" class="btn btn-primary">Create Feedback</a>
    </div>
    
    <table class="table table-bordered table-striped">
        <thead class="thead-light">
            <tr>
            
                <th>Name</th>
                <th>Email</th>
                <th>Review</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
      <c:forEach var="feed" items="${feedbacksList}"> 
            <tr>
               
                <td>${feed.name}</td>
                <td>${feed.email}</td>
                <td>${feed.comments}</td>
                <td>
                    <a href="editFeedback.jsp?id=${feed.email} class="btn btn-warning btn-sm">Edit</a>
                   
                    <form action="FeedbackDelete" method="POST" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this payment?');">
                            <input type="hidden" name="email" value="${feed.email}"> 
                            <button type="submit">Delete</button>
                        </form>
                   
                    
                </td>
            </tr>
  </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
