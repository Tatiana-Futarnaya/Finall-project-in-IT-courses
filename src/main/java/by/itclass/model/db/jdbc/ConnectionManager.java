package by.itclass.model.db.jdbc;

import by.itclass.constants.AppConstant;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {//управляет нашим соединением
    private static Connection connection;
    private static Properties properties;
    /*private static String URL="jdbc:mysql://localhost:3306/itclass_po57?serverTimezone=Europe/Minsk";
    private static String USER="root";
    private static String PASSWORD="";
    private static String DRIVER="com.mysql.cj.jdbc.Driver";*/

    static {
        InputStream in = ConnectionManager.class
                .getClassLoader()
                .getResourceAsStream(AppConstant.DB_PROPERTIES_FILE);
        System.out.println(in);
        properties = PropertiesManager.load(in);
        try {
            Class.forName(properties.getProperty(AppConstant.DRIVER_PROPERTY));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        if(connection==null || connection.isClosed()){
            connection= DriverManager.getConnection(properties.getProperty(AppConstant.URL_PROPERTY),properties);
        }
        return connection;
    }
}
