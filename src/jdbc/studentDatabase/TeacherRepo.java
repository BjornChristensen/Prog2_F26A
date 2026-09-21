package jdbc.studentDatabase;

import java.sql.*;
import java.util.HashMap;

public class TeacherRepo {
  Connection con;

  TeacherRepo(Connection con) {
    this.con = con;
  }

  HashMap<Integer, Teacher> getTeachers() throws SQLException {
    HashMap<Integer, Teacher> map = new HashMap<>();
    String sql = "SELECT * FROM teacher";
    PreparedStatement ps = con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      int id = rs.getInt("teacher_id");
      String name = rs.getString("name");
      map.put(id, new Teacher(id, name));
    }
    return map;
  }
}
