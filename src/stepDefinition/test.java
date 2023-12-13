package stepDefinition;

import org.testng.annotations.Test;
import org.testng.annotations.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class test {
    static Connection con = null;
    private static Statement stmt;
    public static String DB_URL = "jdbc:oracle:thin:@http://localhost:8081:XE";
    public static String DB_USER = "SYS";
    public static String DB_PASSWORD = "admin";

    @BeforeTest
    public void setUp() throws Exception {
        try{
            String dbClass = "oracle.jdbc.OracleDriver";
            Class.forName(dbClass).newInstance();
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {

    }
    @AfterTest
    public void tearDown() throws Exception {
        if (con != null) {
            con.close();
        }
    }
}
