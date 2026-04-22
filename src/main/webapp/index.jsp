<%@ page language="java" %>
<html>
<body>

<h2>Add Cookie</h2>

<form action="addCookie.jsp" method="post">
    Name: <input type="text" name="cname" required><br><br>
    Domain: <input type="text" name="cdomain" required><br><br>
    Expiry Time (in seconds): <input type="number" name="cage" required><br><br>
    
    <input type="submit" value="Add Cookie">
</form>

<br><br>
<a href="viewCookies.jsp">Go to Active Cookie List</a>

</body>
</html>