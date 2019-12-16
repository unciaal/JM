package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static DBHelper dbHelper;
    private static Connection connection = null;


    public DBHelper() {
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
    }

    public static Connection getDbHelperFactory() {
        if (connection == null) {
            dbHelper = new DBHelper();
        }
        return connection;
    }
}
