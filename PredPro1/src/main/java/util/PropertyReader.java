package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static PropertyReader propertyReader;
    private static String jdbcURL;
    private static String usernameJdbc;
    private static String passwordJdbc;
    static FileInputStream fileInputStream;
    static Properties prop;

    public PropertyReader() {
        prop = new Properties();
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String DBPath = rootPath + "config.properties";

            fileInputStream = new FileInputStream(DBPath);
            prop.load(fileInputStream);
            jdbcURL = prop.getProperty("jdbcURL");
            usernameJdbc = prop.getProperty("jdbcUsername");
            passwordJdbc = prop.getProperty("passwordJdbc");
        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл config.properties не обнаружен");
            e.printStackTrace();
        }

    }
    public static String getProperty(String property) {
        if (propertyReader == null) {
            propertyReader = new PropertyReader();
        }

        switch (property) {
            case "jdbcURL" :
                return jdbcURL;
            case "usernameJdbc" :
                return usernameJdbc;
            case "passwordJdbc" :
                return passwordJdbc;
        }
        return null;
    }
}
