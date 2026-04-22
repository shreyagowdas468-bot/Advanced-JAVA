<html>
<head>
    <title>User Form</title>

    <script>
        function validateForm() {
            let name = document.forms["userForm"]["username"].value;
            let email = document.forms["userForm"]["email"].value;
            let designation = document.forms["userForm"]["designation"].value;

            if (name == "" || email == "" || designation == "") {
                alert("All fields must be filled out");
                return false;
            }

            let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
            if (!email.match(emailPattern)) {
                alert("Invalid Email format");
                return false;
            }

            return true;
        }
    </script>
</head>

<body>

<h2>User Data Form</h2>

<form name="userForm" action="UserDataServlet" method="post" onsubmit="return validateForm()">
    
    Username: <input type="text" name="username"><br><br>
    
    Email: <input type="text" name="email"><br><br>
    
    Designation: <input type="text" name="designation"><br><br>
    
    <input type="submit" value="Submit">
</form>

</body>
</html>