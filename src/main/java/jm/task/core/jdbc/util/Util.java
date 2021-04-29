package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost/jm";
            String username = "root";
            String password = "We_love_JAVA_100%";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                return conn;
            } catch (SQLException throwables) {
                System.out.println("Connection failed...");
                System.out.println(throwables);
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return null;
    }
}
