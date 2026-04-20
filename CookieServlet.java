/*
  Build a servlet program to  create a cookie to get your name through text box and press submit button( through HTML)  to display the message by greeting Welcome back your name ! , you have visited this page n times ( n = number of your visit )  along with the list of cookies and demonstrate the expiry of cookie also. 

 */

package com.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        int count = 1;

        // Get existing cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("username")) {
                    name = c.getValue();
                }

                if (c.getName().equals("visitCount")) {
                    count = Integer.parseInt(c.getValue()) + 1;
                }
            }
        }

        // Create cookies
        Cookie nameCookie = new Cookie("username", name);
        Cookie countCookie = new Cookie("visitCount", String.valueOf(count));

        // Set expiry (example: 25 seconds)
        nameCookie.setMaxAge(25);
        countCookie.setMaxAge(25);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // Output
        out.println("<html><body>");

        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + count + " times</h3>");
        out.println("<p><b>(Cookies expire in 25 seconds)</b></p>");

        // Display all cookies
        out.println("<h3>List of Cookies:</h3>");

        cookies = request.getCookies(); // fetch again

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("Name: " + c.getName() + " | Value: " + c.getValue() + "<br>");
            }
        } else {
            out.println("No cookies found");
        }

        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}