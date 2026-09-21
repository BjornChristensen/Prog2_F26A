package jdbc.studentDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentApp {
  public static void main(String[] args) {
    String db="jdbc:mysql://localhost:3306/student_db";
    String user="bjorn";
    String pw="bjch";
    Connection connection=null;
    try {
      connection = DriverManager.getConnection(db, user, pw);
      System.out.println("Connection OK");
    } catch (SQLException e) {
      e.printStackTrace();
      System.exit(1);
    }

    StudentRepo studentRepo=new StudentRepo(connection);
    ClassRepo classRepo = new ClassRepo(connection);
    TeacherRepo teacherRepo = new TeacherRepo(connection);
    HasRepo hasRepo = new HasRepo(connection);
    try {
      HashMap<String, Student> studentMap=studentRepo.getStudents();
      System.out.println(studentMap);
      HashMap<String, ClassEK> classMap=classRepo.getClasses();
      System.out.println(classMap);
      HashMap<Integer, Teacher> teacherMap=teacherRepo.getTeachers();
      System.out.println(teacherMap);
      ArrayList<Has> hasList=hasRepo.getHas();
      System.out.println(hasList);

      // Hvilke studerende underviser Bjørn
      int teacher_id=0;
      for (Teacher t:teacherMap.values()){
        if (t.name.equals("Bjørn")){
          teacher_id=t.teacher_id;
          break;
        }
      }
      String class_name=null;
      for (Has h:hasList) {
        if (h.teacher_id==teacher_id) {
          class_name=h.class_name;
          break;
        }
      }
      ArrayList<Student> studentList=new ArrayList<>();
      for (Student s:studentMap.values()){
        if (s.class_name.equals(class_name)){
          studentList.add(s);
        }
      }
      System.out.println(studentList);

    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      ArrayList<Student> list=studentRepo.getStudentsByTeacher("Bjørn");
      System.out.println(list);
    } catch (SQLException e) { e.printStackTrace(); }

    try {
      studentRepo.addStudent(new Student("kaj001@ek.dk", "Kaj", "F26A"));
      System.out.println(studentRepo.getStudents().values());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
