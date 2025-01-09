package dal;

import entity.Student;
import java.util.List;

public interface StudentInterface {
    public List<Student> getAllStudent();
    public void addStudent(int id, String name, int age);
    public boolean removeStudent(int id);
    public Student getStudentById(int id);
}
