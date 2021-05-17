package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoHibernateImpl user = new UserDaoHibernateImpl();
        user.createUsersTable();
        user.saveUser("Matilda", "Floyd", (byte) 2);
        user.saveUser("Edward", "Hunter", (byte) 86);
        user.saveUser("Joseph", "King", (byte) 85);
        user.saveUser("Emma", "Williams", (byte) 27);
        user.getAllUsers();
        user.cleanUsersTable();
        user.dropUsersTable();
    }
}
