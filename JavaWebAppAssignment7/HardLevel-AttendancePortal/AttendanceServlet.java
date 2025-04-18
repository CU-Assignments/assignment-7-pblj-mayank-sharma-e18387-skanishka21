import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttendanceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String status = request.getParameter("status");

        Properties props = new Properties();
        InputStream input = getServletContext().getResourceAsStream("/WEB-INF/db-config.properties");
        props.load(input);

        String dbURL = props.getProperty("db.url");
        String dbUser = props.getProperty("db.user");
        String dbPass = props.getProperty("db.password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            String query = "INSERT INTO attendance (student_name, roll_number, status, date) VALUES (?, ?, ?, CURDATE())";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, roll);
            stmt.setString(3, status);

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                request.setAttribute("studentName", name);
                RequestDispatcher rd = request.getRequestDispatcher("attendance-success.jsp");
                rd.forward(request, response);
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            response.setContentType("text/html");
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
