package service;

import DAO.DailyReportDao;
import model.DailyReport;

import java.util.List;

public class DailyReportService {

    private static DailyReportService dailyReportService;
    private static DailyReportDao dailyReportDao;

    private DailyReportService() {
    dailyReportDao =new DailyReportDao();
    }

    public static DailyReportService getInstance() {
        if (dailyReportService == null) {
            dailyReportService = new DailyReportService();
        }
        return dailyReportService;
    }



    public List<DailyReport> getAllDailyReports() {
        return  dailyReportDao.getAllDailyReport();
    }

    public DailyReport getLastReport() {
        List<DailyReport> list=getAllDailyReports();
        if (list.isEmpty()){
            DailyReport dailyReport= new DailyReport(0L, 0L);
            addDailyReport(dailyReport);
            return dailyReport;
        }

        return  list.get(list.size()-1);
    }
public DailyReport getPreviousReport() {
        List<DailyReport> list=getAllDailyReports();
        if (list.size()<2){
            DailyReport dailyReport= new DailyReport(0L, 0L);
            addDailyReport(dailyReport);
            return dailyReport;
        }

        return  list.get(list.size()-2);
    }

   public void addDailyReport(DailyReport dailyReport){
        dailyReportDao.addDailyReport(dailyReport);
   }

   public void updateDailyReport(DailyReport dailyReport){
        dailyReportDao.updateDailyReport(dailyReport);
   }

   public void deleteAllDailyReports(){
        dailyReportDao.deleteAllDailyReports();
   }


}
