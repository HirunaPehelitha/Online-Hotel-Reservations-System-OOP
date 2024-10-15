<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Users Management</title>
    <link rel="stylesheet" type="text/css" href="detail.css"> <!-- Make sure the CSS file path is correct -->
</head>
<body>

<div class="container"> 
    <h1>Registered Users</h1>

    <table border="1">
        <thead>
            <tr>
                <th>Email</th>
                <th>Username</th> 
                <th>Password</th>
                <th>Actions</th> 
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${UserList}">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.username}</td> <!-- Changed from ${users.UserName} to ${user.username} -->
                    <td>${user.password}</td>
                    <td><!-- Add action buttons here if needed --></td>
                    
                         
            <td>
                        <button><a href="Userupdate.jsp?id=${user.email}">Edit</a></button>
                        <form action="Userdelete" method="POST" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this payment?');">
                            <input type="hidden" name="email" value="${user.email}"> 
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div> 

</body>
</html>
