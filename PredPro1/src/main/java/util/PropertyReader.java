package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";
    private static String jdbcURL;
    private static String usernameJdbc;
    private static String passwordJdbc;
    FileInputStream fileInputStream;
    Properties prop = new
            Properties();

    public PropertyReader() {
        try {
            //обращаемся к файлу и получаем данные
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            jdbcURL = prop.getProperty("site");
            usernameJdbc = prop.getProperty("login");
            passwordJdbc = prop.getProperty("password");
        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружено");
            e.printStackTrace();
        }
    }
    public static String getProperty(String property) {
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
