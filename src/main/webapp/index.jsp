<html>
<head>
    <title>Student Result Form</title>

    <script>
        function validateForm() {
            let f = document.forms["resultForm"];

            let roll = f["rollno"].value;
            let name = f["name"].value;
            let s1 = f["sub1"].value;
            let s2 = f["sub2"].value;
            let s3 = f["sub3"].value;
            let s4 = f["sub4"].value;
            let s5 = f["sub5"].value;

            if (roll == "" || name == "" || s1 == "" || s2 == "" || s3 == "" || s4 == "" || s5 == "") {
                alert("All fields are required");
                return false;
            }

            let subjects = [s1, s2, s3, s4, s5];

            for (let i = 0; i < subjects.length; i++) {
                if (subjects[i] < 0 || subjects[i] > 100) {
                    alert("Marks should be between 0 and 100");
                    return false;
                }
            }

            return true;
        }
    </script>
</head>

<body>

<h2>Student Result Form</h2>

<form name="resultForm" action="ResultServlet" method="post" onsubmit="return validateForm()">

    Roll No: <input type="text" name="rollno"><br><br>
    Name: <input type="text" name="name"><br><br>

    Subject 1: <input type="number" name="sub1"><br><br>
    Subject 2: <input type="number" name="sub2"><br><br>
    Subject 3: <input type="number" name="sub3"><br><br>
    Subject 4: <input type="number" name="sub4"><br><br>
    Subject 5: <input type="number" name="sub5"><br><br>

    <input type="submit" value="Calculate Result">

</form>

</body>
</html>