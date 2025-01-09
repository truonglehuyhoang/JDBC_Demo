package application;

import dal.StudentDAO;
import entity.Student;
import java.util.List;

public class TestStudent {
    public static void main(String[] args) {
        StudentDAO std = new StudentDAO(); // Instantiate DAO class
        List<Student> list = std.getAllStudent(); // Fetch all students
        for (Student stu : list) {
            System.out.println(stu); // Print each student
        }
        //std.addStudent(4, "Michael", 20);
        //std.removeStudent(4);
        //std.getStudentById(1);
        std.closeConnection(); // Close the connection
    }
}
