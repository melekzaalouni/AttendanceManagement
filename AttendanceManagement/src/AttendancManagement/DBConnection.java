package AttendancManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Attendance Management;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";

    private static final String USER = "javaUser";
    private static final String PASSWORD = "***REMOVED***";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion SQL OK ");
        } catch (Exception e) {
            System.out.println("Erreur connexion SQL : " + e.getMessage());
        }
        return con;
    }
}
