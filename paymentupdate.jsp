<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit</title>
</head>


<style>

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Arial', sans-serif;
}

body {
    background-color: #f4f4f4;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
}

/* Form container styles */
.login-box {
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    padding: 40px;
    max-width: 400px;
    width: 100%;
}

.login-box h2 {
    text-align: center;
    margin-bottom: 20px;
    font-size: 24px;
    color: #333;
}

.input-box {
    position: relative;
    margin-bottom: 30px;
}

.input-box input,
.input-box select {
    width: 100%;
    padding: 10px;
    font-size: 16px;
    border: none;
    border-bottom: 2px solid #ddd;
    outline: none;
    background: transparent;
    color: #333;
    transition: border-color 0.3s ease;
}

.input-box input:focus,
.input-box select:focus {
    border-color: #3498db;
}

.input-box label {
    position: absolute;
    top: 50%;
    left: 10px;
    color: #888;
    pointer-events: none;
    transform: translateY(-50%);
    transition: 0.3s;
}

.input-box input:focus + label,
.input-box input:not(:placeholder-shown) + label,
.input-box select:focus + label,
.input-box select:not(:placeholder-shown) + label {
    top: -10px;
    left: 10px;
    font-size: 12px;
    color: #3498db;
}

/* Row and column styles for expiration date and CVV */
.row {
    display: flex;
    justify-content: space-between;
}

.col {
    flex: 1;
    margin-right: 10px;
}

.col:last-child {
    margin-right: 0;
}

/* Button styles */
button {
    width: 100%;
    padding: 10px;
    background-color: red;
    border: none;
    color: #fff;
    font-size: 16px;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: blue;
}


@media (max-width: 768px) {
    .login-box {
        padding: 20px;
    }

    .row {
        flex-direction: column;
    }

    .col {
        margin-right: 0;
        margin-bottom: 10px;
    }
}

</style>
<body>

<section>
    <div class="login-box">
        <h2>Update Payment Information</h2>
        
        <form action="Payupdate" method="POST" id="update-payment-form">
           
            <!-- Cardholder Name -->
            <div class="input-box">
                <input type="text" id="name" name="userName" required>
                <label>Cardholder Name</label>
            </div>

            <!-- Email -->
            <div class="input-box">
                <input type="email" id="email" name="paymentEmail" required>
                <label>Email</label>
            </div>

            <!-- Country -->
            <div class="input-box">
                <input type="text" id="country" name="country" required>
                <label>Country</label>
            </div>

            <!-- City -->
            <div class="input-box">
                <input type="text" id="city" name="city" required>
                <label>City</label>
            </div>

            <!-- Credit Card Type -->
            <div class="input-box">
                <select id="card-type" name="cardtype" required>
                    <option value="visa">Visa</option>
                    <option value="mastercard">MasterCard</option>
                    <option value="amex">American Express</option>
                    <option value="discover">Discover</option>
                </select>
                <label>Credit Card Type</label>
            </div>

            <!-- Card Number -->
            <div class="input-box">
                <input type="text" id="card-number" name="cardNumber" required>
                <label>Card Number</label>
            </div>

            <!-- Expiration Date and CVV -->
            <div class="row">
                <div class="col">
                    <div class="input-box">
                        <input type="text" id="expiry" name="cardExp" placeholder="MM/YY" required>
                        <label>Expiration Date</label>
                    </div>
                </div>
                <div class="col">
                    <div class="input-box">
                        <input type="text" id="cvv" name="cardCVV" required>
                        <label>CVV</label>
                    </div>
                </div>
            </div>

            <!-- Update Button -->
            <button type="submit">Update Payment</button>
        </form>
    </div>
</section>

<script src="scriptthila.js"></script>
<script src="payment.js"></script>
</body>
</html>