<%@ page session="true" %>
<html>
<body>

<%
    String name = request.getParameter("username");
    String timeStr = request.getParameter("time");

    if (name != null && timeStr != null) {
        int time = Integer.parseInt(timeStr);

        session.setAttribute("user", name);

        // Convert minutes to seconds
        session.setMaxInactiveInterval(time * 60);
    }

    String user = (String) session.getAttribute("user");

    if (user != null) {
%>
        <h2>Hello <%= user %>!</h2>
        <p>Your session is active.</p>

        <a href="check.jsp">Click here to check session</a>
<%
    } else {
%>
        <h2>Session Expired!</h2>
        <a href="index.jsp">Go Back</a>
<%
    }
%>

</body>
</html>