package by.itclass.model.db.jdbc;

import by.itclass.constants.AppConstant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    public static Properties load(InputStream inputStream){
        Properties properties=new Properties();
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return properties;
    }
}
