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
        sessionFactory= DBHelper.getSessionFactory();
    }

    public List<DailyReport> getAllDailyReport() {
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<DailyReport> dailyReports = session.createQuery("FROM DailyReport").list();
        transaction.commit();
        session.close();
        return dailyReports;
    }

    public void deleteAllDailyReports() {
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE DailyReport").executeUpdate();
        transaction.commit();
        session.close();

    }



    public void addDailyReport(DailyReport report) {
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(report);
        transaction.commit();
        session.close();
    }

    public void updateDailyReport(DailyReport report) {
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(report);
        transaction.commit();
        session.close();
    }
}
