package service;

import DAO.CarDao;
import DAO.DailyReportDao;
import model.Car;
import model.DailyReport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class CarService {
    private static CarDao carDao;

    private static CarService carService;
    private CarService() {
        carDao=new CarDao();
    }

    public static CarService getInstance() {
        if (carService == null) {
            carService = new CarService();
        }
        return carService;
    }
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }
    public Car carSearch(Car car){
        return carDao.searchCar(car);
    }

    public void addcar(Car car){
        carDao.addCar(car);
    }

    public void delete(Car car){
        carDao.delete(car);
    }

     public void deleteAllCar(){
         carDao.deleteAllCars();
     }


    public long countBrand(String brand){

        return getAllCars().stream().filter(s->s.getBrand().equals(brand)).count();

    }






}
