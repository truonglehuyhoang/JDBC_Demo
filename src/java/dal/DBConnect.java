package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    protected Connection c;

    public DBConnect() {
        try {
            String url ="jdbc:sqlserver://localhost:1433;databaseName=Buoi3_JDBC;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String pass = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection(url,username,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (c != null && !c.isClosed()) {
                c.close();
                System.out.println("Connection closed successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}