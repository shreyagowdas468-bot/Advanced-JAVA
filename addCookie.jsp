<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="java.net.URLEncoder" %>

<html>
<head>
    <title>Cookie Added</title>
</head>
<body>

<%
    String name = request.getParameter("name");
    String domain = request.getParameter("domain");
    String ageStr = request.getParameter("age");

    if(name == null || name.isEmpty() || ageStr == null || ageStr.isEmpty()){
%>
        <h3 style="color:red;">Error: All fields are required!</h3>
        <a href="index.jsp">Go Back</a>
<%
    } else {
        try {
            int age = Integer.parseInt(ageStr);

            // Encode value to avoid space error
            String encodedName = URLEncoder.encode(name, "UTF-8");

            Cookie cookie = new Cookie("user", encodedName);

            cookie.setMaxAge(age);

            if(domain != null && !domain.isEmpty()){
                cookie.setDomain(domain);
            }

            response.addCookie(cookie);
%>
            <h2 style="color:green;">Cookie Added Successfully!</h2>

            <p><b>Name:</b> <%= name %></p>
            <p><b>Domain:</b> <%= domain %></p>
            <p><b>Max Age:</b> <%= age %> seconds</p>

            <br>
            <a href="showCookies.jsp">Go to Active Cookie List</a>

<%
        } catch(NumberFormatException e){
%>
            <h3 style="color:red;">Error: Invalid age value!</h3>
            <a href="index.jsp">Go Back</a>
<%
        }
    }
%>

</body>
</html>