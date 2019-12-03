package com.slk.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Repository;
@Repository
public class SDBUtil {
private static Connection connection = null;
	
	public static Connection getConnection() throws IOException {
		
        if (connection != null)
            return connection;
        else {
            try {
            	Properties prop = new Properties();
           
               InputStream inputStream = SDBUtil.class.getClassLoader().getResourceAsStream("config.properties");
               prop.load(inputStream);
             /*String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/sapphirebank";
                String user = "root";
                String password = "1234";
                Class.forName(driver);*/
               String driver = prop.getProperty("driver");
               String url = prop.getProperty("url");
               String user = prop.getProperty("user");
               String password = prop.getProperty("password");
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }



}
