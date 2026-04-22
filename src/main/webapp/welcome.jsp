<%@ page session="true" %>
<html>
<body>

<%
    String name = request.getParameter("username");

    if (name != null) {
        session.setAttribute("user", name);

        // Set session expiry to 1 minute
        session.setMaxInactiveInterval(60);
    }

    String user = (String) session.getAttribute("user");

    if (user != null) {
%>
        <h2>Hello <%= user %>!</h2>
        <p>Your session will expire in 1 minute.</p>
<%
    } else {
%>
        <h2>Session Expired!</h2>
        <p>Please enter your name again.</p>
        <a href="index.html">Go Back</a>
<%
    }
%>

</body>
</html>