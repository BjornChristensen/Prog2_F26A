package jdbc.studentDatabase;

import java.sql.*;
import java.util.HashMap;

public class ClassRepo {
  Connection con;

  ClassRepo(Connection con) {
    this.con = con;
  }

  HashMap<String, ClassEK> getClasses() throws SQLException {
    HashMap<String, ClassEK> map = new HashMap<>();
    String sql = "SELECT * FROM class";
    PreparedStatement ps = con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      String name = rs.getString("name");
      String class_room = rs.getString("classroom");
      map.put(name, new ClassEK(name, class_room));
    }
    return map;
  }
}
