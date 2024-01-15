package lib;

import org.testng.annotations.Test;

import java.sql.*;

public class DBConnect {
    public static Statement DBConnect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection =
                DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/eCommerce","postgres", "admin");

        Statement st = connection.createStatement();
        return st;
    }
    @Test
    public void runSelectQuery() throws SQLException, ClassNotFoundException {
        Statement st = DBConnect();
        String selectquery = "select * from Colors";
        ResultSet rs = st.executeQuery(selectquery);
        ResultSetMetaData rsmd = rs.getMetaData();
        if(rs!=null){
            while (rs.next()){
                for (int i=1; i<=rsmd.getColumnCount(); i++){
                    System.out.print(rs.getString(i)+" ");
                }
                System.out.println("");
            }
        }
    }
}
