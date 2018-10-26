package Server;

import java.sql.*;

public class LibraryServer {

    public LibraryServer() {
        String mysqlUrl =
                "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String mysqlUser = "root";
        String mysqlPasswd = "123456";
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPasswd);
            // st = con.createStatement();
            System.out.println("Mysql is linked!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LibraryServer lib = new LibraryServer();
    }
}
