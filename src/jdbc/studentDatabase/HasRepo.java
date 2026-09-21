package jdbc.studentDatabase;

import java.sql.*;
import java.util.ArrayList;

public class HasRepo {
  Connection con;

  HasRepo(Connection con) {
    this.con = con;
  }

  ArrayList<Has> getHas() throws SQLException {
    ArrayList<Has> list = new ArrayList<>();
    String sql = "SELECT * FROM has";
    PreparedStatement ps = con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      int teacher_id = rs.getInt("teacher_id");
      String class_name = rs.getString("class_name");
      list.add(new Has(teacher_id, class_name));
    }
    return list;
  }
}
