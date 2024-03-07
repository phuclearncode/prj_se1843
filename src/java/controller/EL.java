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
import java.util.ArrayList;
import model.Category;

/**
 *
 * @author phuonglh
 */
@WebServlet(name="EL", urlPatterns = {"/el"})
public class EL extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO cDao = new CategoryDAO();
        ArrayList<Category> list = cDao.getAllCategories();
        req.setAttribute("list", list);
        Category c = new Category(10,"Test");
        req.setAttribute("category", c);
        req.getRequestDispatcher("EL.jsp").forward(req, resp);
    }
    
}
