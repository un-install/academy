package lesson17;

import lesson17.models.Offices;
import lesson17.models.Orders;
import lesson17.models.Products;
import oracle.jdbc.OracleDriver;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;

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

    public static ResultSet getResultSet(String query) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);
        return stmt.executeQuery();
    }


    public static Orders newOrderByRs(ResultSet rs, Products product) throws SQLException {
        return new Orders(rs.getBigDecimal("order_num"), rs.getDate("order_date"),
                rs.getBigDecimal("CUST"), rs.getBigDecimal("rep"),
                rs.getString("mfr"),
                rs.getBigDecimal("qty"), rs.getBigDecimal("amount"), product);
    }

    public static Products newProductByRs(ResultSet rs) throws SQLException {
        return new Products(rs.getString("MFR_ID"), rs.getString("PRODUCT_ID"),
                rs.getString("DESCRIPTION"), rs.getBigDecimal("PRICE"), rs.getBigDecimal("QTY_ON_HAND"));
    }
    public static Offices newOfficeByRs(ResultSet rs) throws SQLException {
        return new Offices(rs.getBigDecimal("office"), rs.getString("city"),
                rs.getString("region"), rs.getBigDecimal("mgr"),
                rs.getBigDecimal("target"), rs.getBigDecimal("sales"));
    }

    public static void closeAllCloseble(AutoCloseable ...objs) {
        try {
        for (AutoCloseable o : objs) {
                o.close();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
