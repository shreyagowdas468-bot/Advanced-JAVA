<%@ page session="true" %>
<html>
<body>

<%
    String user = (String) session.getAttribute("user");

    if (user != null) {
%>
        <h2>Hello <%= user %>!</h2>
        <p>Session is still active.</p>
<%
    } else {
%>
        <h2>Session Expired!</h2>
        <p>Your session time is over.</p>
        <a href="index.jsp">Start Again</a>
<%
    }
%>

</body>
</html>