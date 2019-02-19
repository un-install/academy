package lesson19.template;

import lesson17.OJDBCUtils;
import lesson17.models.Offices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class abstractDao <K> {
    public boolean template(K tableObj) {
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = null;
        boolean isOk = false;
        try {
            stmt = updateTable(tableObj, conn);
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

    public abstract PreparedStatement updateTable(K tableObj, Connection conn) throws SQLException;
}
