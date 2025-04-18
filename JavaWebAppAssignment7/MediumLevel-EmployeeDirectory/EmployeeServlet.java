import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String empId = request.getParameter("id");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Properties props = new Properties();
        InputStream input = getServletContext().getResourceAsStream("/WEB-INF/db-config.properties");
        props.load(input);

        String dbURL = props.getProperty("db.url");
        String dbUser = props.getProperty("db.user");
        String dbPass = props.getProperty("db.password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            String query;
            if (empId != null && !empId.trim().isEmpty()) {
                query = "SELECT * FROM employees WHERE id = ?";
            } else {
                query = "SELECT * FROM employees";
            }

            PreparedStatement stmt = conn.prepareStatement(query);

            if (empId != null && !empId.trim().isEmpty()) {
                stmt.setInt(1, Integer.parseInt(empId));
            }

            ResultSet rs = stmt.executeQuery();

            out.println("<h2>Employee Details:</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Department</th><th>Email</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id") + "</td><td>" +
                        rs.getString("name") + "</td><td>" +
                        rs.getString("department") + "</td><td>" +
                        rs.getString("email") + "</td></tr>");
            }
            out.println("</table>");

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
            e.printStackTrace(out);
        }
    }
}
