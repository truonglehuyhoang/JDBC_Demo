
package controller;

import dal.StudentDAO;
import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

@WebServlet(name="StudentController", urlPatterns={"/student"})
public class StudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        StudentDAO std = new StudentDAO(); // Instantiate DAO class
        String action = request.getParameter("action");
        String idStr = request.getParameter("id");  
        List<Student> list;
        
        switch(action){
            case "list":
                list = std.getAllStudent();
                request.setAttribute("msg", "Danh Sách Học Sinh: ");
                request.setAttribute("list", list);
                break;
                
            case "delete":
                int deleteId = Integer.parseInt(idStr);
                boolean isDeleted = std.removeStudent(deleteId);
                list = std.getAllStudent();
                request.setAttribute("msg", isDeleted ? "Đã Xóa Thành Công!" : "Không Tìm Thấy Học Sinh.");
                request.setAttribute("list", list);
                break;
                
            case "add":
                int addId = Integer.parseInt(idStr);
                String name = request.getParameter("name");
                int age = Integer.parseInt(request.getParameter("age"));
                std.addStudent(addId, name, age);
                list = std.getAllStudent();
                request.setAttribute("msg", "Đã Thêm Thành Công!");
                request.setAttribute("list", list);
                break;
                
            case "search":
                int searchId = Integer.parseInt(idStr);
                Student student = std.getStudentById(searchId);
                if(student != null){
                    request.setAttribute("msg", "Đã Tìm Thấy Học Sinh: ");
                    request.setAttribute("list", Collections.singletonList(student));
                } else{
                    request.setAttribute("msg", "Không Tìm Thấy Học Sinh.");
                    request.setAttribute("list", null);
                }
                break;
                
            default:
                request.setAttribute("msg", "Vui lòng lựa chọn tính năng");
                request.setAttribute("list", null);
                break;
        }
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }
}
