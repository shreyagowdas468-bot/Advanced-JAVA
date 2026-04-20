<%@ page language="java" %>
<html>
<head>
<title>Student Result</title>

<script>
function validateForm() {
    let roll = document.forms["f"]["roll"].value;
    let name = document.forms["f"]["name"].value;
    let marks = document.getElementsByClassName("marks");

    if (roll == "" || name == "") {
        alert("All fields are required!");
        return false;
    }

    for (let i = 0; i < marks.length; i++) {
        let m = marks[i].value;
        if (m == "" || m < 0 || m > 100) {
            alert("Marks must be between 0 and 100");
            return false;
        }
    }
    return true;
}
</script>

</head>
<body>

<h2>Enter Student Details</h2>

<form name="f" action="ResultServlet" method="post" onsubmit="return validateForm()">

Roll No: <input type="text" name="roll"><br><br>
Name: <input type="text" name="name"><br><br>

Sub1: <input type="number" class="marks" name="s1"><br><br>
Sub2: <input type="number" class="marks" name="s2"><br><br>
Sub3: <input type="number" class="marks" name="s3"><br><br>
Sub4: <input type="number" class="marks" name="s4"><br><br>
Sub5: <input type="number" class="marks" name="s5"><br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>