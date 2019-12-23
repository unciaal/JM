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
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public User selectUser(long id) throws SQLException {
        Transaction transaction = null;
        User user = null;
        try(Session session = sessionFactory.openSession()) {
            user = session.get(User.class,id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
                user = null;
            }
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        Transaction transaction = null;
        List user = null;
        try(Session session = sessionFactory.openSession()) {
            user =  session.createQuery("FROM User").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
                user = null;
            }
        }
        return user;
    }

    @Override
    public boolean deleteUser(long id) throws SQLException {
        Transaction transaction = null;
        boolean status = false;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = session.load(User.class,id);
            session.delete(user);
            transaction.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
                status = false;
            }
        }
        return status;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        Transaction transaction = null;
        boolean status = false;
        try(Session session = sessionFactory.openSession()) {
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
        }
        return status;
    }
}
