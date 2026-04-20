<%@ page import="java.io.*" %>

<%
    String name = request.getParameter("username");
    int time = Integer.parseInt(request.getParameter("time"));

    // Create session
    session.setAttribute("uname", name);

    // Set session expiry time
    session.setMaxInactiveInterval(time);
%>

<html>
<body>

<h2>Hello <%= name %>!</h2>

<p>Session will expire in <%= time %> seconds.</p>

<a href="check.jsp">Click here to check session</a>

</body>
</html>