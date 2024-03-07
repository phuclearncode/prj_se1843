/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Product;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author phuonglh
 */
public class ProductDAO extends DBContext{
    public ArrayList<Product> getProductsByCategoryID(int categoryID){
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Products ";
            if (categoryID > 0){
                sql = sql + " where categoryId = " + categoryID;
            }
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                Product p = new Product();
                p.setProductCode(rs.getString("productCode"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getFloat("price"));
                p.setStockQuantity(rs.getInt("stockQuantity"));
                p.setCategoryId(rs.getInt("categoryId"));
                p.setStartDate(rs.getDate("startDate"));
                p.setImage(rs.getString("image"));
                list.add(p);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public static void main(String[] args){
        ProductDAO pDao = new ProductDAO();
        ArrayList<Product> list = pDao.getProductsByCategoryID(0);
        for (Product p:list){
            System.out.println(p.getName() + " " + p.getCategoryId());
        }
    }
}
