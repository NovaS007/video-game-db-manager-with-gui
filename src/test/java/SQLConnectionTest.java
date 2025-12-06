import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class to test SQL database connection
public class SQLConnectionTest {
    static void main() {
        // Database connection parameters
        // URL Format: jdbc:mysql://hostname:port/databaseName?property1=value1&property2=value2
        final String URL = "jdbc:mysql://localhost:3306/video_game_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "XenobladeChronicles2020!";

        // Establishing a connection within a try-with-resources block to ensure closure
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                System.out.println("Connected to MySQL successfully!");
            }
        }

        // Handling SQL exceptions
        catch (SQLException e) {
            System.err.println("Failed to connect to MySQL");
            e.printStackTrace();
        }
    }
}
