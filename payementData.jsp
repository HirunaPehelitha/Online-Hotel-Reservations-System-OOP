<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Management</title>
    <link rel="stylesheet" type="text/css" href="detail.css"> <!-- Make sure the CSS file path is correct -->
    <style>
        /* Basic styles for buttons */
        button {
            padding: 10px 15px;
            background-color: #007BFF; /* Primary color */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-right: 5px;
        }

        button:hover {
            background-color: #0056b3; /* Darker shade on hover */
        }

        a {
            color: white; /* Link color */
            text-decoration: none; /* Remove underline */
        }

        form {
            display: inline; /* Keep form inline */
        }
    </style>
</head>
<body>

<div class="container"> 
    <h1>Payment Details</h1>

    <table border="1">
        <thead>
            <tr>
                <th>userName</th>
                <th>paymentEmail</th> 
                <th>country</th>
                <th>city</th>
                <th>cardtype</th>
                <th>cardNumber</th>
                <th>cardExp</th>
                <th>cardCVV</th>
                <th>Actions</th> 
            </tr>
        </thead>
        <tbody>
            <c:forEach var="pay" items="${PayList}"> 
                <tr>
                    <td>${pay.userName}</td>
                    <td>${pay.paymentEmail}</td> 
                    <td>${pay.country}</td>
                    <td>${pay.city}</td>
                    <td>${pay.cardtype}</td>
                    <td>${pay.cardNumber}</td>
                    <td>${pay.cardExp}</td>
                    <td>${pay.cardCVV}</td>
                    <td>
                        <button><a href="paymentupdate.jsp?id=${pay.paymentEmail}">Edit</a></button>
                        <form action="PayDelete" method="POST" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this payment?');">
                            <input type="hidden" name="paymentEmail" value="${pay.paymentEmail}"> <!-- Include hidden input to send paymentEmail for deletion -->
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
