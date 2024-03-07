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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Student;

/**
 *
 * @author phuonglh
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/student"})
public class StudentServlet extends HttpServlet {

    private Map<Integer, Student> listStudents = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null || action.length() == 0) {
            action = "list";
        }
        switch (action) {
            case "list":
                listSudents(req, resp);
                break;
            case "add":
                addSudent(req, resp);
                break;
            case "delete":
                deleteSudent(req, resp);
                break;
            case "edit":
                editSudent(req, resp);
                break;
            case "update":
                updateSudent(req, resp);
                break;
            default:
                listSudents(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void listSudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //listStudents.put(1, new Student(1, "Mai", 20, "Hà Nội"));
        //listStudents.put(2, new Student(2, "Nam", 21, "Hà Nội"));
        //listStudents.put(3, new Student(3, "Hùng", 20, "Hà Nội"));
        req.setAttribute("list", listStudents);
        req.getRequestDispatcher("listStudents.jsp").forward(req, resp);
    }

    protected void addSudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String ageStr = req.getParameter("age");
        String address = req.getParameter("address").trim();
        ArrayList<String> error = new ArrayList<>();
        int id = 0, age =0;
        try {
            id = Integer.parseInt(idStr);
            Student s = listStudents.get(id);
            if (s!=null){
                error.add("Student with id = " + id + " already exists.");
            }
        }
        catch (Exception e){
            error.add("Id must be an integer number.");
        }
        
        if (name==null || name.trim().equals("")){
            error.add("Name must not be blank.");
        }
        try{
            age = Integer.parseInt(ageStr);
            if (age <= 16){
                error.add("Age must be greater than 16.");
            }
        }
        catch (Exception e){
            error.add("Age must be an integer number.");
        }
        if (address==null){
            address = "";
        }
        
        if (error.size()==0){
            listStudents.put(id, new Student(id, name, age, address));
            resp.sendRedirect("student");
        }
        else {
            req.setAttribute("error", error);
            req.setAttribute("id", idStr);
            req.setAttribute("name", name);
            req.setAttribute("age", ageStr);
            req.setAttribute("address", address);
            req.getRequestDispatcher("addStudent.jsp").forward(req, resp);
        }
    }
    
    protected void deleteSudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            listStudents.remove(id);
            resp.sendRedirect("student");
        }
        catch (Exception e){
            listSudents(req, resp);
        }
    }
    
    protected void editSudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Student s = listStudents.get(id);
            if (s==null){
                resp.sendRedirect("student");
            }
            else {
                req.setAttribute("student", s);
                req.getRequestDispatcher("editStudent.jsp").forward(req, resp);
            }
        }
        catch (Exception e){
            resp.sendRedirect("student");
        }
    }
    
    protected void updateSudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String ageStr = req.getParameter("age");
        String address = req.getParameter("address").trim();
        ArrayList<String> error = new ArrayList<>();
        int id = 0, age =0;
        try {
            id = Integer.parseInt(idStr);
        }
        catch (Exception e){
            error.add("Id must be an integer number.");
        }
        
        if (name==null || name.trim().equals("")){
            error.add("Name must not be blank.");
        }
        try{
            age = Integer.parseInt(ageStr);
            if (age <= 16){
                error.add("Age must be greater than 16.");
            }
        }
        catch (Exception e){
            error.add("Age must be an integer number.");
        }
        if (address==null){
            address = "";
        }
        
        if (error.size()==0){
            if (listStudents.get(id)!=null){
                listStudents.put(id, new Student(id, name, age, address));
            }
            resp.sendRedirect("student");
        }
        else {
            req.setAttribute("error", error);
            //req.setAttribute("id", idStr);
            //req.setAttribute("name", name);
            //req.setAttribute("age", ageStr);
            //req.setAttribute("address", address);
            Student s = new Student(id, name, age, address);
            req.setAttribute("student", s);
            req.getRequestDispatcher("editStudent.jsp").forward(req, resp);
        }
    }
}
