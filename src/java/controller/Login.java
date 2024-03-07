/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.Student;

/**
 *
 * @author phuonglh
 */
public class Login extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Servlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Login form</h2>");
            
            String error = req.getParameter("error");
            if (error != null && error.equals("1")){
                out.println("<p style=\"color:red\">Username and/or password is not correct. Please input again:</p>");
            }
            
            out.println("<form action=\"login\" method=\"post\">");
            out.println("Username: <input type=\"text\" name=\"user\"/><br/>");
            out.println("Password: <input type=\"password\" name=\"pass\"/><br/>");
            out.println("<input type=\"submit\" value=\"Login\"/>");
            out.println("</form>");   
            
            ServletConfig c = this.getServletConfig();
            String name = c.getInitParameter("name");
            String age = c.getInitParameter("age");
            String address = c.getInitParameter("address");
            Student s = new Student(1,name, Integer.parseInt(age), address);
            out.println(s);
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Servlet</title>");  
            out.println("</head>");
            out.println("<body>");
            
            String username = req.getParameter("user");
            String password = req.getParameter("pass");
            String user1 = req.getServletContext().getInitParameter("user1");
            String pass1 = req.getServletContext().getInitParameter("pass1");
            String user2 = req.getServletContext().getInitParameter("user2");
            String pass2 = req.getServletContext().getInitParameter("pass2");
            if (username.equalsIgnoreCase(user1) && password.equals(pass1)
                    || username.equalsIgnoreCase(user2) && password.equals(pass2)){
                out.println("Hello " + username);
            }
            else {
                resp.sendRedirect("login?error=1");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
}
