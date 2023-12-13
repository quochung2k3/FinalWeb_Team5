package hcmute.team5.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionSQL {
    private final String serverName = "MILU";
    private final String dbName = "FinalWeb";
    private final String portNumber = "1433";
    private final String instance = "";// MSSQLSERVER LEAVE THIS ONE
    private final String userID = "new";
    private final String password = "new";

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try {
            System.out.println(new DBConnectionSQL().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}