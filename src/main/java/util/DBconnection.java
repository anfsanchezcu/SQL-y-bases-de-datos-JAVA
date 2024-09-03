package util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    final private static String URL = "jdbc:mysql://localhost:3306/project";
    final private static String USER = "root";
    final private static String PASSWORD ="admin";

    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {
        if(pool ==null){
            pool = new BasicDataSource();
            pool.setUrl(URL);
            pool.setUsername(USER);
            pool.setPassword(PASSWORD);

            pool.setInitialSize(3);
            pool.setMinIdle(3); //minimo de conexiones inactivas permitidas
            pool.setMaxIdle(10); // maximo conexiones permitidas
            pool.setMaxTotal(10);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException{
        return  getInstance().getConnection();
    }
}
