package com.m2iformation.jdbcVilles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionBDD {

    private static Connection connection;
    private static Properties props = new Properties();
    private static String url;
    private static String login;
    private static String password;
    
    static {
        getProp();
    }
    
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, login, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(connection);
        return connection;
    }
    
    private final static void getProp() {
        // lecture de notre conf.properties se trouvant dans notre src/main/resources
        try(InputStream fis = ConnectionBDD.class.getClassLoader().getResourceAsStream("conf.properties")){
            
            props.load(fis);
            
            Class.forName(props.getProperty("jdbc.driver.class"));
            
            url = props.getProperty("jdbc.url");
            login = props.getProperty("jdbc.login");
            password = props.getProperty("jdbc.password");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}