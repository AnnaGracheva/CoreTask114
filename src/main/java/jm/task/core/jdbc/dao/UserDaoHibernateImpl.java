package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        final String CREATE_TABLE_QUERY =
                "CREATE TABLE IF NOT EXISTS users "
                        + "(id INT(5) NOT NULL AUTO_INCREMENT,"
                        + " name VARCHAR(50), "
                        + " lastName VARCHAR(50), "
                        + " age INT(3), "
                        + "PRIMARY KEY (id));";
        Transaction transaction = null;
        Session session = null;
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query newQuery = session.createSQLQuery(CREATE_TABLE_QUERY);
            int create = newQuery.executeUpdate();
            System.out.println("Table completed");
            System.out.println("create " + create);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        final String DROP_TABLE =
                "DROP TABLE IF EXISTS users";
        Transaction transaction = null;
        Session session = null;
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query newQuery = session.createSQLQuery(DROP_TABLE);
            int drop = newQuery.executeUpdate();
            System.out.println("Table deleted");
            System.out.println("drop " + drop);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        Transaction transaction = null;
        Session session = null;
        try{
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        final String REMOVE_USER =
                "DELETE FROM users WHERE (id = '" + id + "')";
        Transaction transaction = null;
        Session session = null;
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query newQuery = session.createSQLQuery(REMOVE_USER);
            int remove = newQuery.executeUpdate();
            System.out.println("User removed by id");
            System.out.println("remove " + remove);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        String s = "FROM User";
        List<User> list = new ArrayList<>();
        Transaction transaction = null;
        Session session = null;
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query newQuery = session.createQuery(s);
            list = newQuery.list();
            System.out.println(list);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        final String CLEAN_TABLE =
                "TRUNCATE TABLE users";
        Transaction transaction = null;
        Session session = null;
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query newQuery = session.createSQLQuery(CLEAN_TABLE);
            int clean = newQuery.executeUpdate();
            System.out.println("Table cleared");
            System.out.println("clear " + clean);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
