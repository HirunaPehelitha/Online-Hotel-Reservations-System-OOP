<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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


.update-box {
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    padding: 40px;
    max-width: 400px;
    width: 100%;
}

.update-box h2 {
    text-align: center;
    margin-bottom: 20px;
    font-size: 24px;
    color: #333;
}

.input-box {
    position: relative;
    margin-bottom: 30px;
}

.input-box input {
    width: 100%;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ddd;
    border-radius: 5px;
    outline: none;
    transition: border-color 0.3s ease;
}

.input-box input:focus {
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
.input-box input:not(:placeholder-shown) + label {
    top: -10px;
    left: 10px;
    font-size: 12px;
    color: #3498db;
}


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

</style>
<body>
<section>
    <div class="update-box">
        <h2>Update User Information</h2>
        <form action="Userupdate" method="POST" id="update-form">
            <div class="input-box">
                <input type="text" id="name" name="UserName" required>
                <label>Full Name</label>
            </div>

            <div class="input-box">
                <input type="email" id="email" name="email" required>
                <label>Email</label>
            </div>

            <div class="input-box">
                <input type="text" id="phone" name="password" required>
                <label>Password</label>
            </div>

           

            <button type="submit">Update Information</button>
        </form>
    </div>
</section>



</body>
</html>