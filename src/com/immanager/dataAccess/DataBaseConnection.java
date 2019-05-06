package com.immanager.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @desc Singleton which allows you to connect to the database
 */
public final class DataBaseConnection {
    private Connection connection;
    private static DataBaseConnection instance;

    private DataBaseConnection(){
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "immanager";
        String username = "root";
        String password = "vdd2019";

        try {
            this.connection = DriverManager.getConnection(url + dbName + "?useSSL=false", username, password);
        }
        catch (Exception sqlE){
            sqlE.printStackTrace();
        }
    }

    /**
     * @return DataBaseConnection object
     */
    public static synchronized DataBaseConnection getInstance() {
        if ( instance == null ) {
            instance = new DataBaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
