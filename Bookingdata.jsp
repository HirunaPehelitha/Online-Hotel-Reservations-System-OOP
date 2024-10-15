<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking Management</title>
    <link rel="stylesheet" type="text/css" href="detail.css"> <!-- Make sure the CSS file path is correct -->
</head>
<body>

<div class="container"> 
    <h1>Booking Details</h1>

    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th> 
                <th>Check-In</th>
                <th>Check-Out</th>
                <th>Guests</th>
                <th>Room Type</th>
                <th>Rooms</th>
                <th>Loyalty</th>
                <th>Actions</th> 
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${BookList}"> 
                <tr>
                    <td>${book.name}</td>
                    <td>${book.email}</td> 
                    <td>${book.checkIn}</td>
                    <td>${book.checkOut}</td>
                    <td>${book.guests}</td>
                    <td>${book.roomType}</td>
                    <td>${book.rooms}</td>
                    <td>${book.loyalty}</td>
                     <td>
                <button><a href="BookingUpdate.jsp?id=${book.email}">Edit</a></button> | 
                <button><a href="BookingDelete?id=${book.email}">Delete</a></button>
                   </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div> 

</body>
</html>
