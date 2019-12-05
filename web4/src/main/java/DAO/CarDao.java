package DAO;

import model.Car;
import model.DailyReport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CarDao {

    private SessionFactory sessionFactory;



    public CarDao() {
        sessionFactory= DBHelper.getSessionFactory();
    }

    public List<Car> getAllCars() {
        Session session = sessionFactory.openSession();
        List<Car> cars = Collections.emptyList();;
       try {
           cars = session.createQuery("FROM Car").list();
       } catch (NullPointerException e) {
           e.printStackTrace();
       } finally {
           session.close();
           return cars;
       }

    }

    public void addCar(Car car) {
        Session session=sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
            session.close();
    }

    public void delete(Car car) {
        Session session=sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.delete(car);
        transaction.commit();
        session.close();

    }

    public void deleteAllCars() {
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE Car").executeUpdate();
        transaction.commit();
        session.close();

    }

    public Car searchCar(Car car){
        Session session=sessionFactory.openSession();

        Car cars= (Car) session.createQuery(" FROM Car where brand=:brand " +
                "and model=:model " +
                "and licensePlate=:licensePlate")
                .setParameter("brand", car.getBrand())
                .setParameter("model", car.getModel())
                .setParameter("licensePlate", car.getLicensePlate())
                .uniqueResult();
            session.close();
            return cars;
    }


}