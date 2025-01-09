
package controller;

import dal.StudentDAO;
import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                try{
                    int deleteId = Integer.parseInt(idStr);
                    boolean isDeleted = std.removeStudent(deleteId);
                    list = std.getAllStudent();
                    request.setAttribute("msg", isDeleted ? "<h2 style='color:green;'>Đã Xóa Thành Công!</h2>" 
                                                            : "<h2 style='color:red;'>Không Tìm Thấy Học Sinh.</h2>");
                    request.setAttribute("list", list);
                } catch(Exception e){
                    e.printStackTrace();
                }
                break;
                
            case "add":
                try{
                    int addId = Integer.parseInt(idStr);
                    String name = request.getParameter("name");
                    int age = Integer.parseInt(request.getParameter("age"));
                    std.addStudent(addId, name, age);
                    list = std.getAllStudent();
                    request.setAttribute("msg", "<h2 style='color:green;'>Đã Thêm Thành Công!</h2>");
                    request.setAttribute("list", list);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
                
            case "search":
                try{
                    int searchId = Integer.parseInt(idStr);
                    Student student = std.getStudentById(searchId);
                    if(student != null){
                        request.setAttribute("msg", "<h2 style='color:green;'>Kết Quả Tìm Kiếm: </h2>");
                        request.setAttribute("list", Collections.singletonList(student));
                    } else{
                        request.setAttribute("msg", "<h2 style='color:red;'>Không Tìm Thấy Học Sinh.</h2>");
                        request.setAttribute("list", null);
                    }
                } catch(Exception e){
                    e.printStackTrace();
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
