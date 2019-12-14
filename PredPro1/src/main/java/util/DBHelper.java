package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static DBHelper dbHelper;
    private static Connection connection = null;

    public static DBHelper getDbHelperFactory() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
            connection = getConnection();
        }
        return dbHelper;
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    PropertyReader.getProperty("jdbcURL"),
                    PropertyReader.getProperty("usernameJdbc"),
                    PropertyReader.getProperty("passwordJdbc"));
            connection.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
