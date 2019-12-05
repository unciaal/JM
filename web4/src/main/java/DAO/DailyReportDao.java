package DAO;

import model.DailyReport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class DailyReportDao {

    private SessionFactory sessionFactory;

    public DailyReportDao() {
        sessionFactory = DBHelper.getSessionFactory();
    }

    public List<DailyReport> getAllDailyReport() {
        Session session = null;
        Transaction transaction = null;
        List<DailyReport> dailyReports = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            dailyReports = session.createQuery("FROM DailyReport").list();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
           if (session != null) {
               session.close();
           }
        }
        return dailyReports;
    }

    public void deleteAllDailyReports() {
        Session session = null;
        Transaction transaction = null;
        try {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.createQuery("DELETE DailyReport").executeUpdate();
        transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }


    public void addDailyReport(DailyReport report) {
        Session session = null;
        Transaction transaction = null;
        try {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(report);
        transaction.commit();
    } catch (Exception e) {
        if(transaction != null) {
            transaction.rollback();
        }
    } finally {
        if (session != null) {
            session.close();
        }
    }
    }

    public void updateDailyReport(DailyReport report) {
        Session session = null;
        Transaction transaction = null;
        try {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.update(report);
        transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
