package servlet;

import com.google.gson.Gson;
import model.Car;
import model.DailyReport;
import service.CarService;
import service.DailyReportService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String json = gson.toJson(CarService.getInstance().getAllCars());
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String brand= req.getParameter("brand");
    String model= req.getParameter("model");
    String licensePlate= req.getParameter("licensePlate");
        Car car=CarService.getInstance().carSearch(new Car(brand, model, licensePlate));
        if (car!=null) {
            DailyReport dailyReport=DailyReportService.getInstance().getLastReport();
            dailyReport.setEarnings(dailyReport.getEarnings()+car.getPrice());
            dailyReport.setSoldCars(dailyReport.getSoldCars()+1);
            DailyReportService.getInstance().updateDailyReport(dailyReport);
            CarService.getInstance().delete(car);
            resp.setStatus(HttpServletResponse.SC_OK);
        }else {
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }





    }
}
