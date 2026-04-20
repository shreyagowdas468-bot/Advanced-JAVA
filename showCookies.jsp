<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="java.net.URLDecoder" %>

<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if(cookies != null){
        for(Cookie c : cookies){
            String name = c.getName();
            String value = URLDecoder.decode(c.getValue(), "UTF-8");
%>
            <p>
                <b>Name:</b> <%= name %> 
                | <b>Value:</b> <%= value %>
                | <b>Max Age:</b> <%= c.getMaxAge() %>
            </p>
<%
        }
    } else {
%>
        <h3>No cookies found!</h3>
<%
    }
%>

<br>
<a href="index.jsp">Back to Home</a>

</body>
</html>