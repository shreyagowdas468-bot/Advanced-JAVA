<%@ page session="true" %>
<html>
<body>

<%
    String name = request.getParameter("username");

    if (name != null) {
        session.setAttribute("user", name);
        session.setMaxInactiveInterval(60); // 1 minute (60 seconds)
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
<%
    }
%>

</body>
</html>