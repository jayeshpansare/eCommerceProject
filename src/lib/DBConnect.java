package lib;

import org.testng.annotations.Test;

import java.sql.*;

public class DBConnect {
    public static Statement DBConnect(){
        Statement st = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection =
                    DriverManager
                            .getConnection("jdbc:postgresql://localhost:5432/eCommerce", "postgres", "admin");
            st = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
}
