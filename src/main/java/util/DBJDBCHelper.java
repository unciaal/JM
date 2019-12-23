package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBJDBCHelper {
    private static DBJDBCHelper dbHelper;
    private static Connection connection = null;


    public DBJDBCHelper() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    PropertyReader.getProperty("jdbcURL"),
                    PropertyReader.getProperty("username"),
                    PropertyReader.getProperty("password"));
            connection.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getDbHelperFactory() {
        if (connection == null) {
            dbHelper = new DBJDBCHelper();
        }
        return connection;
    }
}
