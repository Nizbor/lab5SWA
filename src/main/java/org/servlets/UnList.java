package org.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/UnList")
public class UnList extends HttpServlet {
    private DataSource ds;
    private void getDataSource() throws NamingException {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        ds = (DataSource) envCtx.lookup("jdbc/task2");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            getDataSource();
            Connection con = ds.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(
                    "SELECT teacher_lesson.*, teacher.first_name, teacher.last_name, lesson.name_lesson FROM teacher_lesson" +
                    " INNER JOIN teacher ON teacher_lesson.id_teacher  = teacher.id_teacher"
                            + " INNER JOIN lesson ON teacher_lesson.id_lesson  = lesson.id_lesson");
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            out.write("<html>");
            out.write("<body>");

            out.write("<h3>org.servlets.UnList</h3>");
            while(rs.next())  {
                out.write(rs.getString("first_name") + " ");
                out.write(rs.getString("last_name") + " - ");
                out.write( rs.getString("name_lesson"));
                out.write("</br>");
            }
        } catch (SQLException | NamingException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception in closing DB resources");
            }
        }
    }
}
