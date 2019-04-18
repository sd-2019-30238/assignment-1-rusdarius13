package DAO;

import java.sql.*;


public class DbConnection {
    static Connection con = null;

    public static Connection getConnection() throws Exception {
        try {
            if (con == null) {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/dealengingeschema?useSSL=false", "root", "admin");
            }
        }
         finally {
            con.close();
        }
        return con;
    }
}
