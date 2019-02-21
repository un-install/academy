package lesson19.template;

import lesson17.OJDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DaoFunctionalInterface {
    default boolean template(Connection conn) {
        PreparedStatement stmt = null;
        boolean isOk = false;
        try {
            stmt = updateTable(conn);
            isOk = stmt.executeUpdate() > 0;

            System.out.println(" Done");
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            OJDBCUtils.closeAllCloseble(stmt, conn);
            return isOk;
        }
    }

    PreparedStatement updateTable(Connection conn) throws SQLException;
}
