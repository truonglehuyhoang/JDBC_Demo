package dal;

import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.internal.compiler.batch.Main;


public class StudentDAO extends DBConnect implements StudentInterface{
    @Override
    public List<Student> getAllStudent(){
        String sql = "SELECT * FROM Student";
        List<Student> list = new ArrayList<>();
        try{
            PreparedStatement stm = c.prepareStatement(sql); //Will write the above sql statements into JVM
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                Student s = new Student(id, name, age);
                list.add(s);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public void addStudent(int id, String name, int age){
        String sql = "INSERT INTO Student (id, name, age) " + " VALUES (?,?,?)";
        try{
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, name);
            stm.setInt(3, age);
            stm.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean removeStudent(int id){
        String sql = "DELETE FROM Student " + " WHERE id=?";
        try{
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, id);
            int rowsAffected = stm.executeUpdate();
            
            if(rowsAffected > 0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Student getStudentById(int id){
        String sql = "SELECT * FROM Student WHERE id=?";
        try{
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");      
                Student s = new Student(id, name, age);
                return s;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
