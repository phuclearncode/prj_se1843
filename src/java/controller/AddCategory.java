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
@WebServlet(name="AddCategory", urlPatterns = {"/addCategory"})
public class AddCategory extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            CategoryDAO cDao = new CategoryDAO();
            if (cDao.getCategoryByID(id) == null){
                cDao.insertCategory(new Category(id,name));
                resp.sendRedirect(req.getContextPath() + "/listCategory");
            }
            else { // da co category voi id nhap vao
                String error = "ID " + id + " already exists.";
                req.setAttribute("error", error);
                req.setAttribute("category", new Category(id, name));
                req.getRequestDispatcher("AddCategory.jsp").forward(req, resp);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/listCategory");
        }
    }
    
}
