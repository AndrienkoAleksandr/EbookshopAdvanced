package com.bookshop.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by USER on 13.08.2014.
 */
public class EshopQueryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Connection connector = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connector = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "develop");
            stmt = connector.createStatement();
            String[] authors = req.getParameterValues("author");
            String lineOfAuthors = "";
            for (String author: authors) {
                lineOfAuthors += "'" + author + "'" + ", ";
            }
            lineOfAuthors = lineOfAuthors.substring(0, lineOfAuthors.lastIndexOf(", "));
            String sqlStr = "SELECT * From books WHERE author IN (" + lineOfAuthors + ")" +
                    " AND qty > 0 AND price < " + req.getParameter("price") +
                    " ORDER BY author ASC, title ASC";
            ResultSet rset = stmt.executeQuery(sqlStr);
            out.println("<html><head><title>Query Results</title></head><body>");
            out.println("<form method='get' action='eshoporder'>");
            while(rset.next()) {
            out.println("<p><input type='checkbox' name='id' value="
                        + "'" + rset.getString("id") + "' />"
                        + rset.getString("author") + ", "
                        + rset.getString("title") + ", $"
                        + rset.getString("price") + "</p>");
            }
            out.println("<p><input type='submit' value='ORDER' />");
            out.println("</form>");
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
            try {
                if (stmt != null ) {
                    stmt.close();
                }
                if (connector != null ) {
                    connector.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
