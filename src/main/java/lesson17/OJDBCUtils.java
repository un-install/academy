package lesson17;

import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OJDBCUtils {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MA_STUDENT", "KOLOBOK");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
