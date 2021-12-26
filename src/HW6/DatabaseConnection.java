package HW6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private DatabaseConnection() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres?currentSchema=shop",
                    "admin",
                    "admin");
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database", e);
        }
    }
}
