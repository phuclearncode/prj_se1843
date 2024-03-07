/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author phuonglh
 */
public class Cal extends HttpServlet{

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
            
            try {
                double x = Double.parseDouble(req.getParameter("x"));
                double y = Double.parseDouble(req.getParameter("y"));
                String operator = req.getParameter("operator");
                double result = 0;
                switch (operator) {
                    case "+":
                        result = x+y;
                        break;
                    case "-":
                        result = x-y;
                        break;
                    case "*":
                        result = x*y;
                        break;
                    case "/":
                        result = x/y;
                        break;
                }
                out.println(x + operator + y + "=" + result);
            }
            catch(Exception e){
                out.println(e);
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
}
