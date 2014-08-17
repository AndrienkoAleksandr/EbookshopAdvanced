package com.bookshop.servlets;

import com.bookshop.util.DataBaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by USER on 13.08.2014.
 */
public class EshopOrderServlet extends HttpServlet {
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
            connector = DataBaseConnection.getConnection();
            stmt = connector.createStatement();
            // Step 3 & 4: Execute a SQL SELECT query and Process the query result
            out.println("<html><head><title>Order Results</title></head><body>");

// Retrieve the books' id. Can order more than one books.
            String[] ids = req.getParameterValues("id");
            if (ids != null) {
                String sqlStr;
                int count;
                // Process each of the books
                for (int i = 0; i < ids.length; ++i) {
                    // Update the qty of the table books
                    sqlStr = "UPDATE books SET qty = qty - 1 WHERE id = " + ids[i];
                    out.println("<p>" + sqlStr + "</p>");  // for debugging
                    count = stmt.executeUpdate(sqlStr);
                    out.println("<p>" + count + " record updated.</p>");

                    // Create a transaction record
                    sqlStr = "INSERT INTO order_records (id, qty_ordered) VALUES ("
                            + ids[i] + ", 1)";
                    out.println("<p>" + sqlStr + "</p>");  // for debugging
                    count = stmt.executeUpdate(sqlStr);
                    out.println("<p>" + count + " record inserted.</p>");
                    out.println("<h3>Your order for book id=" + ids[i]
                            + " has been confirmed.</h3>");
                }
                out.println("<h3>Thank you.<h3>");
            } else { // No book selected
                out.println("<h3>Please go back and select a book...</h3>");
            }
            out.println("</body></html>");
        } catch (SQLException e) {
            out.println("Couldn't connect to baseDate");
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
