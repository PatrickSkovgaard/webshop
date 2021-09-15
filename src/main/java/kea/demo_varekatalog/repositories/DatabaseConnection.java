package kea.demo_varekatalog.repositories;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    public Connection getConnection() {

        Connection connection;

        // Reads from properties for the purpose of hidding password
        try (InputStream stream = new FileInputStream("src/main/resources/application.properties")){
            Properties properties = new Properties();
            properties.load(stream);
            String dbConnection = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(dbConnection,username,password);
        }
        catch(Exception e){
            System.out.println("Problem with property file reading...\n" + e.getMessage());
            e.printStackTrace();
            connection = null;
        }
        return connection;
    }
}
