package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHibernateHelper;

import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDao {
    private SessionFactory sessionFactory;

    public UserHibernateDAO() {
        sessionFactory = DBHibernateHelper.getSessionFactory();
    }

    @Override
    public void insertUser(User user) throws SQLException {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
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
    public User selectUser(long id) throws SQLException {
        Transaction transaction = null;
        Session session = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            user = (User) session.createQuery("FROM User where id = :id").uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
                user = null;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        Transaction transaction = null;
        Session session = null;
        List user = null;
        try {
            session = sessionFactory.openSession();
            user =  session.createQuery("FROM User").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
                user = null;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public boolean deleteUser(long id) throws SQLException {
        Transaction transaction = null;
        Session session = null;
        boolean status = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(id);
            transaction.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
                status = false;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return status;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        Transaction transaction = null;
        Session session = null;
        boolean status = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
                status = false;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return status;
    }
}
