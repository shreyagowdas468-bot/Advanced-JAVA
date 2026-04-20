<%
    String name = (String) session.getAttribute("uname");
%>

<html>
<body>

<%
    if (name != null) {
%>
        <h2>Welcome back <%= name %>!</h2>
        <p>Your session is still active.</p>
<%
    } else {
%>
        <h2>Session Expired!</h2>
        <p>Please go back and enter your details again.</p>
<%
    }
%>

<br>
<a href="index.html">Go Back</a>

</body>
</html>