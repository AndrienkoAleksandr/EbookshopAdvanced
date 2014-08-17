package com.bookshop.util;

import com.bookshop.exception.ConnectionException;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by USER on 13.08.2014.
 */
public class DataBaseConnection {
    private static String[] configParamName = new String[]{"url", "username", "password"};
    private static String baseDate = "ebookshop";
    private static String urlBaseDate = "jdbc:mysql://localhost:3306/" + baseDate;
    private static String userName = "root";
    private static String password = "develop";

    public static Connection getConnection() throws ClassNotFoundException, SQLException, ConnectionException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(urlBaseDate, userName, password);
    }

    public static void setUrlBaseDate(String urlBaseDate) {
        DataBaseConnection.urlBaseDate = urlBaseDate;
    }

    public static void setUserName(String userName) {
        DataBaseConnection.userName = userName;
    }

    public static void setPassword(String password) {
        DataBaseConnection.password = password;
    }
}
