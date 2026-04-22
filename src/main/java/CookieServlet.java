import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        int visitCount = 1;

        Cookie[] cookies = request.getCookies();

        // Check existing cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                }
            }
        }

        // Create cookies with set values
        Cookie nameCookie = new Cookie("username", name);
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set expiry (demonstration purpose)
        nameCookie.setMaxAge(30);      // 30 seconds
        visitCookie.setMaxAge(30);

        response.addCookie(nameCookie);
        response.addCookie(visitCookie);

        out.println("<html><body>");

        // Greeting message
        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times.</h3>");

        // Show cookie set values
        out.println("<h3>Cookie Set Values:</h3>");
        out.println("<p>Name Cookie: username = " + name + "</p>");
        out.println("<p>Visit Cookie: visitCount = " + visitCount + "</p>");
        out.println("<p><i>Cookies will expire in 30 seconds</i></p>");

        // Display all cookies
        out.println("<h3>List of Cookies:</h3>");

        Cookie[] allCookies = request.getCookies();

        if (allCookies != null) {
            for (Cookie c : allCookies) {
                out.println("<p>");
                out.println("<b>Name:</b> " + c.getName() + "<br>");
                out.println("<b>Value:</b> " + c.getValue());
                out.println("</p><hr>");
            }
        } else {
            out.println("<p>No cookies found</p>");
        }

        out.println("</body></html>");
    }
}