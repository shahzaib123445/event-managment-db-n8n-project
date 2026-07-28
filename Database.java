import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://your-host:3306/your_dbname";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";
    private Connection conn;

    public Database() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to Railway!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return conn;
    }
    public void close() {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}