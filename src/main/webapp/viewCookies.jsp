<%@ page import="javax.servlet.http.*" %>
<html>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
%>
            <p>
                <b>Name:</b> <%= c.getName() %> <br>
                <b>Value:</b> <%= c.getValue() %>
            </p>
            <hr>
<%
        }
    } else {
%>
        <p>No Cookies Found</p>
<%
    }
%>

<br>
<a href="index.jsp">Back</a>

</body>
</html>