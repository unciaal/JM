package servlet;

import DAO.DailyReportDao;
import com.google.gson.Gson;
import model.DailyReport;
import service.CarService;
import service.DailyReportService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DailyReportServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Gson gson = new Gson();
        String json = null;
        resp.setStatus(HttpServletResponse.SC_OK);


        if (req.getPathInfo().contains("all")) {
            json=gson.toJson(DailyReportService.getInstance().getAllDailyReports());
        } else if (req.getPathInfo().contains("last")) {
            json=gson.toJson(DailyReportService.getInstance().getPreviousReport());

        }
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
    DailyReportService.getInstance().deleteAllDailyReports();
    CarService.getInstance().deleteAllCar();
    }
}
