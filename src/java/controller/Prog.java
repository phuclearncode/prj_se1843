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
public class Prog extends HttpServlet{

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
            
            String[] prog = req.getParameterValues("prog");
            if (prog.length == 0){
                out.println("Bạn chưa chọn ngôn ngữ lập trình nào.");
            }
            else {
                out.println("Bạn đã chọn các ngôn ngữ lập trình sau: <br/>");
                out.println("<ul>");
                for (String p:prog){
                    out.println("<li>");
                    out.println(p);
                    out.println("</li>");
                }
                out.println("</ul>");
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
