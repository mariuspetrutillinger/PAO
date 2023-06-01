import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection getConnection() throws SQLException {
        // JDBC driver name and database URL
        String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "c##proiect_user";
        String password = "1106";

        Connection conn = null;

        try {
            // Register the JDBC driver
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Open a connection
        return DriverManager.getConnection(dbUrl, username, password);
    }
}
