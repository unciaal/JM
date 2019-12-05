import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.hibernate.SessionFactory;
import servlet.CustomerServlet;
import servlet.DailyReportServlet;
import servlet.NewDayServlet;
import servlet.ProducerServlet;
import util.DBHelper;

public class Main {

    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        CustomerServlet customerServlet = new CustomerServlet();
        NewDayServlet newDayServlet = new NewDayServlet();
        ProducerServlet producerServlet = new ProducerServlet();
        DailyReportServlet dailyReportServlet=new DailyReportServlet();

        context.addServlet(new ServletHolder(customerServlet), "/customer");
        context.addServlet(new ServletHolder(newDayServlet),"/newday");
        context.addServlet(new ServletHolder(producerServlet), "/producer");
        context.addServlet(new ServletHolder(dailyReportServlet), "/report/*");

        Server server = new Server(8080);
        server.setHandler(context);


        server.start();
        server.join();
    }
}