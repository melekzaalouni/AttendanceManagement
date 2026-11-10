package AttendancManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = System.getenv().getOrDefault("DB_URL",
            "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Attendance Management;"
            + "encrypt=true;"
            + "trustServerCertificate=true;");

    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {
        Connection con = null;
        if (USER == null || PASSWORD == null) {
            System.out.println("Erreur connexion SQL : variables d'environnement DB_USER et DB_PASSWORD manquantes");
            return null;
        }
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
