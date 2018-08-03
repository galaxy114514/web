package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Utils {
    public static DataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource();
    }

    //DataSource
    public static DataSource getDataSource() {
        return  dataSource;
    }


    //Connection
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
