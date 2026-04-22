import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResultServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String roll = request.getParameter("rollno");
        String name = request.getParameter("name");

        int s1 = Integer.parseInt(request.getParameter("sub1"));
        int s2 = Integer.parseInt(request.getParameter("sub2"));
        int s3 = Integer.parseInt(request.getParameter("sub3"));
        int s4 = Integer.parseInt(request.getParameter("sub4"));
        int s5 = Integer.parseInt(request.getParameter("sub5"));

        // Server-side validation
        if (roll.isEmpty() || name.isEmpty()) {
            response.getWriter().println("All fields are required!");
            return;
        }

        int[] marks = {s1, s2, s3, s4, s5};

        for (int m : marks) {
            if (m < 0 || m > 100) {
                response.getWriter().println("Invalid marks entered!");
                return;
            }
        }

        // Calculate result
        int total = s1 + s2 + s3 + s4 + s5;
        double avg = total / 5.0;

        boolean pass = true;
        for (int m : marks) {
            if (m < 40) {
                pass = false;
                break;
            }
        }

        String result = pass ? "PASS" : "FAIL";

        // Set attributes
        request.setAttribute("roll", roll);
        request.setAttribute("name", name);
        request.setAttribute("s1", s1);
        request.setAttribute("s2", s2);
        request.setAttribute("s3", s3);
        request.setAttribute("s4", s4);
        request.setAttribute("s5", s5);
        request.setAttribute("avg", avg);
        request.setAttribute("result", result);

        // Forward to JSP
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}