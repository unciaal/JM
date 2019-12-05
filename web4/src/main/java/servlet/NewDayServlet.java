package servlet;

import com.google.gson.Gson;
import model.DailyReport;
import service.CarService;
import service.DailyReportService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewDayServlet extends HttpServlet {
    DailyReportService dailyReportService=DailyReportService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String json = gson.toJson(dailyReportService.getLastReport());
        dailyReportService.addDailyReport(new DailyReport(0L, 0L));
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(json);


    }
}
