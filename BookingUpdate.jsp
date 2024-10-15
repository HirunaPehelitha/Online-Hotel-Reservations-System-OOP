<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Hotel Reservation System</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="book.css">
    <link rel="icon" href="images/logo.png" type="image/png">
    <style>
        body {
            font-family: 'Montserrat', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 400px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333; 
        }

        .input-box {
            margin: 10px 0;
        }

        .input-box label {
            display: block;
            margin-bottom: 5px;
            color: #333; 
        }

        .input-box input,
        .input-box select {
            width: 80%%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9; /* Lighter background for input */
            color: #333; /* Dark text for input */
        }

        button {
            padding: 10px;
            background-color: #5cb85c;
            border: none;
            border-radius: 5px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            width: auto; 
            margin: 0 auto; 
            display: block; 
        }

        button:hover {
            background-color:red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Update Booking</h1>
        <form id="booking-update-form" action="UpdateBooking" method="post">
            <div class="input-box">
                <label for="name">Name</label>
                <input type="text" id="name" name="Name" required>
            </div>
            
            <div class="input-box">
                <label for="email">Email</label>
                <input type="email" id="email" name="Email" required>
            </div>
            
            <div class="input-box">
                <label for="check-in-date">Check-in Date</label>
                <input type="date" id="check-in-date" name="CheckIn" required>
            </div>
            
            <div class="input-box">
                <label for="check-out-date">Check-out Date</label>
                <input type="date" id="check-out-date" name="CheckOut" required>
            </div>
            
            <div class="input-box">
                <label for="guests">No. of Guests</label>
                <input type="number" id="guests" name="Guests" required>
            </div>
            
            <div class="input-box">
                <label for="room-type">Room Type</label>
                <select id="room-type" name="RoomType" required>
                    <option value="standard">Standard</option>
                    <option value="deluxe">Deluxe</option>
                    <option value="suite">Luxury</option>
                </select>
            </div>
            
            <div class="input-box">
                <label for="rooms">No. of Rooms</label>
                <input type="number" id="rooms" name="Rooms" required>
            </div>
            
            <div class="input-box">
                <label>Loyalty Member</label>
                <label><input type="radio" name="loyalty" value="yes"> Yes</label>
                <label><input type="radio" name="loyalty" value="no"> No</label>
            </div>
            
            <button type="submit">Update Reservation</button>
        </form>
    </div>

    <script src="book.js"></script>
</body>
</html>
