/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
@WebServlet(name = "Login2", urlPatterns = {"/login2"})
public class Login2 extends HttpServlet{

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
            String username = req.getParameter("user");
            String password = req.getParameter("pass");
            if (username.equalsIgnoreCase("Phuong") && password.equals("123")){
                out.println("<p>Hello " + username + "</p>");
            }
            else {
                //resp.sendRedirect("login2.jsp?error=1");
                String error = "Username and/or password is not correct.";
                Student s = new Student(1,"Mai", 20, "Hanoi");
                req.setAttribute("err", error);
                req.setAttribute("student", s);
                req.getRequestDispatcher("login2.jsp").forward(req, resp);
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
