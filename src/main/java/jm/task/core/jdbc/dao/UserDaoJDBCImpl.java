package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Util util = new Util();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        /*final String CREATE_TABLE_QUERY =
                "CREATE TABLE IF NOT EXISTS users "
                        + "(id INT(5) NOT NULL AUTO_INCREMENT,"
                        + " name VARCHAR(50), "
                        + " lastName VARCHAR(50), "
                        + " age INT(3), "
                        + "PRIMARY KEY (id));";
        try (Connection connection = util.getConnection();
                Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_TABLE_QUERY);
            System.out.println("Table completed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

         */
    }


    public void dropUsersTable() {
        /*final String DROP_TABLE =
                "DROP TABLE IF EXISTS users";
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(DROP_TABLE);
            System.out.println("Table deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

         */
    }

    public void saveUser(String name, String lastName, byte age) {
        /*final String CREATE_USER =
                "INSERT INTO users (name , lastName, age) VALUES (?, ?, ?)";
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement stmt = connection.prepareStatement(CREATE_USER);
            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setInt(3, age);
            stmt.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

         */
    }

    public void removeUserById(long id) {
        /*final String REMOVE_USER =
                "DELETE FROM users WHERE ID = ?";
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement stmt = connection.prepareStatement(REMOVE_USER);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            System.out.println("User removed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

         */
    }

    public List<User> getAllUsers() {
        /*String sql = "SELECT * FROM users;";
        List<User> list = new ArrayList<>();
        try (Connection connection = util.getConnection();
             PreparedStatement stm = connection.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User s = new User();
                s.setId(rs.getLong("id"));
                s.setName(rs.getString("name"));
                s.setLastName(rs.getString("lastName"));
                s.setAge(rs.getByte("age"));
                list.add(s);
                System.out.println(s);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        */
        return null; //list;
    }

    public void cleanUsersTable() {
        /*final String CLEAN_TABLE =
                "TRUNCATE TABLE users";
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(CLEAN_TABLE);
            System.out.println("Table cleared");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

         */
    }
}
