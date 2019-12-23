package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static String PropertyReader(String property) {
        String answer = null;
        FileInputStream fileInputStream;
        Properties prop = new Properties();

        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String DBPath = rootPath + "config.properties";
            fileInputStream = new FileInputStream(DBPath);
            prop.load(fileInputStream);
            answer = prop.getProperty(property);
        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл config.properties не обнаружен");
            e.printStackTrace();
        }
        return answer;
    }

    public static String getProperty(String property) throws NullPointerException {
        String answer = null;
        try {
            answer = PropertyReader(property);
            if (answer == null) {
                throw new NullPointerException(property);
            }
        } catch (NullPointerException e) {
            System.out.println(String.format("Ошибка в программе: свойство %s в файле properties не обнаружено", e));
            e.printStackTrace();
        }
        return answer;
    }
}
