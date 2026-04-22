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

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visit")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                }
            }
        }

        // Create / Update cookies
        Cookie nameCookie = new Cookie("username", name);
        Cookie visitCookie = new Cookie("visit", String.valueOf(visitCount));

        // Set expiry time (in seconds)
        nameCookie.setMaxAge(30);   // 30 seconds
        visitCookie.setMaxAge(30);

        response.addCookie(nameCookie);
        response.addCookie(visitCookie);

        out.println("<html><body>");
        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times.</h3>");
        out.println("<p>Cookie will expire in 30 seconds.</p>");
        out.println("</body></html>");
    }
}