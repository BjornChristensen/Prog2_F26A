package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC_Test {
    public static void main(String[] args)  throws Exception {
        String db="jdbc:mysql://localhost:3306/books_db";
        String user="bjorn";
        String pw="bjch";
        Connection connection = DriverManager.getConnection(db, user, pw);
        System.out.println("Connection OK");

        String query="select * from books";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getString(2));
        }
    }
}
