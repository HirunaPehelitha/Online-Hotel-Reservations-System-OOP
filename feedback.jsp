<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Review Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="ReviewProject.css">
    <script src="ReviewProject.js"></script>
    <style>
        body {
            background-image: url('review-bg.jpg'); 
            background-size: cover; 
            background-position: center; 
            font-family: 'Arial', sans-serif;
        }
        .review-container {
            max-width: 600px;
            margin: 100px auto;
            padding: 30px;
            border: 1px solid #5d5757;
            border-radius: 10px;
            background-color: rgba(233, 233, 223, 0.9);
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #4CAF50; 
            font-family: 'Georgia', serif; 
            font-size: 32px; 
            font-weight: bold; 
        }
        .form-group label {
            font-weight: 600; 
            font-size: 16px; 
            color: #333; 
        }
        .form-group .invalid-feedback {
            display: none;
            color: red;
        }
        button[type="submit"] {
            background-color: #4285F4; 
            color: white; 
            border: none; 
            font-weight: bold; 
            font-size: 16px; 
            transition: background-color 0.3s, transform 0.3s;
        }
        button[type="submit"]:hover {
            background-color: #357AE8; 
            transform: scale(1.05);
        }
        button[type="button"] {
            background-color: #f44336;
            color: white;
            border: none;
            font-weight: bold;
            font-size: 16px;
            transition: background-color 0.3s, transform 0.3s;
        }
        button[type="button"]:hover {
            background-color: #d32f2f;
            transform: scale(1.05);
        }
        .form-control:focus {
            box-shadow: none;
            border-color: #4CAF50; 
        }
        .char-counter {
            font-size: 12px;
            color: #777;
            text-align: right;
        }
    </style>
</head>
<body>
    <div class="review-container">
        <h2>Write a Review</h2>
        <form id="reviewForm" method="POST" action="Feedback" novalidate>
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" required>
                <div class="invalid-feedback">Please enter your name.</div>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
                <div class="invalid-feedback">Please enter a valid email.</div>
            </div>
            <div class="form-group">
                <label for="Comments">Review</label>
                <textarea class="form-control" id="Comments" name="Comments" rows="4" placeholder="Write your review" maxlength="300" required></textarea>
                <div class="char-counter"><span id="charCount">0</span>/300 characters</div>
                <div class="invalid-feedback">Please write a review (max 300 characters).</div>
            </div>
            <div class="d-flex justify-content-between">
                <button type="submit" class="btn" onclick="validateForm()">Submit Review</button>
                <button type="button" class="btn" onclick="clearForm()">Clear Form</button>
            </div>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
        function validateForm() {
            var form = document.getElementById('reviewForm');
            var name = document.getElementById('name');
            var email = document.getElementById('email');
            var comments = document.getElementById('Comments');
            
            if (!name.value) {
                name.classList.add('is-invalid');
            } else {
                name.classList.remove('is-invalid');
            }

            if (!email.value || !validateEmail(email.value)) {
                email.classList.add('is-invalid');
            } else {
                email.classList.remove('is-invalid');
            }

            if (!comments.value) {
                comments.classList.add('is-invalid');
            } else {
                comments.classList.remove('is-invalid');
            }

            if (!form.checkValidity()) {
                event.preventDefault();
            }
        }

        function clearForm() {
            document.getElementById('reviewForm').reset();
            document.getElementById('charCount').textContent = "0";
        }

        function validateEmail(email) {
            var re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return re.test(String(email).toLowerCase());
        }

        var commentBox = document.getElementById('Comments');
        commentBox.addEventListener('input', function() {
            document.getElementById('charCount').textContent = commentBox.value.length;
        });
    </script>
</body>
</html>
