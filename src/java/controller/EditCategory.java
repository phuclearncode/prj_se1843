/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Category;

/**
 *
 * @author phuonglh
 */
@WebServlet(name="EditCategory", urlPatterns = {"/editCategory"})
public class EditCategory extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            CategoryDAO cDao = new CategoryDAO();
            Category c = cDao.getCategoryByID(id);
            if (c==null){
                resp.sendRedirect(req.getContextPath() + "/listCategory");
            }
            else {
                req.setAttribute("category", c);
                req.getRequestDispatcher("editCategory.jsp").forward(req, resp);
            }
        }
        catch (Exception e){
            System.out.println(e);
            resp.sendRedirect(req.getContextPath() + "/listCategory");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            CategoryDAO cDao = new CategoryDAO();
            try {
                cDao.updateCategory(new Category(id,name));
                resp.sendRedirect(req.getContextPath() + "/listCategory");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                resp.sendRedirect(req.getContextPath() + "/listCategory");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/listCategory");
        }
    }
    
}
