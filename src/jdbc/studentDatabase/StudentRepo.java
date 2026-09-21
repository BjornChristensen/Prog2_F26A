package jdbc.studentDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentRepo {
  Connection con;

  StudentRepo(Connection con){
    this.con=con;
  }

  HashMap<String, Student> getStudents() throws SQLException {
    HashMap<String, Student> map=new HashMap<>();
    String sql="SELECT * FROM student";
    PreparedStatement ps=con.prepareStatement(sql);
    ResultSet rs=ps.executeQuery();
    while (rs.next()) {
      String mail=rs.getString("mail");
      String name=rs.getString("name");
      String class_name=rs.getString("class");
      map.put(mail, new Student(mail, name, class_name));
    }
    return map;
  }

  ArrayList<Student> getStudentsByTeacher(String teacher_name) throws SQLException {
    ArrayList<Student> list=new ArrayList<>();
    String sql="SELECT * \n" +
      "FROM student \n" +
      "WHERE class IN (\n" +
      "\tSELECT has.class_name \n" +
      "    FROM has join teacher on has.teacher_id=teacher.teacher_id \n" +
      "    WHERE teacher.name=?);\n";
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setString(1, teacher_name);
    ResultSet rs=ps.executeQuery();
    while (rs.next()) {
      String mail=rs.getString("mail");
      String name=rs.getString("name");
      String class_name=rs.getString("class");
      list.add(new Student(mail, name, class_name));
    }
    return list;
  }

  void addStudent(Student student) throws SQLException {
    String sql="INSERT INTO student(mail,name, class) VALUES(?,?,?);";
    PreparedStatement ps= con.prepareStatement(sql);
    ps.setString(1, student.mail);
    ps.setString(2, student.name);
    ps.setString(3, student.class_name);
    ps.executeUpdate();
  }
}
