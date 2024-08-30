package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    final private static String URL = "jdbc:mysql://localhost:3306/project";
    final private static String USER = "root";
    final private static String PASSWORD ="admin";

    private static Connection myConn;

    public static Connection getInstance() throws SQLException {
        if(myConn ==null)
            myConn = DriverManager.getConnection(URL,USER,PASSWORD);
        return myConn;
    }
}
