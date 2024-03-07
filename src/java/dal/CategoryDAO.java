/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Category;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author phuonglh
 */
public class CategoryDAO extends DBContext{
    public Map<Integer, Category> getMapAllCategories(){
        Map<Integer, Category> list = new HashMap<>();
        try {
            String sql = "select * from Categories";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            // duyet cac ban ghi trong ResultSet va dua vao list
            while (rs.next()){
                Category c = new Category();
                c.setId(rs.getInt("id")); //c.setId(rs.getInt(1));
                c.setName(rs.getString("name"));//c.setName(rs.getString(2));
                list.put(c.getId(), c);
            }
            rs.close();
            st.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    public ArrayList<Category> getAllCategories(){
        ArrayList<Category> list = new ArrayList<>();
        try {
            String sql = "select * from Categories";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            // duyet cac ban ghi trong ResultSet va dua vao list
            while (rs.next()){
                Category c = new Category();
                c.setId(rs.getInt("id")); //c.setId(rs.getInt(1));
                c.setName(rs.getString("name"));//c.setName(rs.getString(2));
                list.add(c);
            }
            rs.close();
            st.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public void deleteCategory(int id){
        try {
            String sql = "delete from Categories where id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void insertCategory(Category c){
        try {
            String sql = "insert into Categories(ID, name) values (?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2, c.getName());
            st.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updateCategory(Category c){
        try {
            String sql = "update Categories set Name = ? where ID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setInt(2, c.getId());            
            st.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Category getCategoryByID(int id){
        try {
            String sql = "select * from Categories where id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();            
            if (rs.next()){
                Category c = new Category();
                c.setId(rs.getInt("id")); //c.setId(rs.getInt(1));
                c.setName(rs.getString("name"));//c.setName(rs.getString(2));
                return c;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static void main(String[] args) {
        CategoryDAO cDao = new CategoryDAO();
        Map<Integer, Category> list = cDao.getMapAllCategories();
        for (int cid : list.keySet()){
            System.out.println(list.get(cid));
        }
    }
}
