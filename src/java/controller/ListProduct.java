/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import model.Category;
import model.Product;

/**
 *
 * @author phuonglh
 */
@WebServlet(name = "ListProduct", urlPatterns = {"/listProduct"})
public class ListProduct extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid = 0;
        try {
            cid = Integer.parseInt(req.getParameter("cid"));
        }
        catch (Exception e){
            cid = 0;
        }
        ProductDAO pDao = new ProductDAO();
        ArrayList<Product> listPro = pDao.getProductsByCategoryID(cid);
        req.setAttribute("listPro", listPro);
        CategoryDAO cDao = new CategoryDAO();
        Map<Integer, Category> listCat = cDao.getMapAllCategories();
        req.setAttribute("listCat", listCat);
        req.setAttribute("cid", cid);
        req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
    }
    
}
