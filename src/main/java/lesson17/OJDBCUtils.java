package lesson17;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lesson17.models.Offices;
import lesson17.models.Orders;
import lesson17.models.Products;

import java.beans.PropertyVetoException;
import java.sql.*;

public class OJDBCUtils {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getResultSet(java.lang.String query) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);
        return stmt.executeQuery();
    }


    public static Orders newOrderByResultSet(ResultSet rs, Products product) throws SQLException {
        return new Orders(rs.getBigDecimal("order_num"), rs.getDate("order_date"),
                rs.getBigDecimal("CUST"), rs.getBigDecimal("rep"),
                rs.getString("mfr"),
                rs.getBigDecimal("qty"), rs.getBigDecimal("amount"), product);
    }

    public static Products newProductByResultSet(ResultSet rs) throws SQLException {
        return new Products(rs.getString("MFR_ID"), rs.getString("PRODUCT_ID"),
                rs.getString("DESCRIPTION"), rs.getBigDecimal("PRICE"), rs.getBigDecimal("QTY_ON_HAND"));
    }
    public static Offices newOfficeByResultSet(ResultSet rs) throws SQLException {
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

    public static ComboPooledDataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
        cpds.setUser("MA_STUDENT");
        cpds.setPassword("KOLOBOK");

        cpds.setInitialPoolSize(5);
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(100);

        return cpds;
    }

    public static void setStatmentOrderValues(PreparedStatement stmt, Orders order) throws SQLException {
        stmt.setBigDecimal(1, order.getOrderNum());
        stmt.setDate(2,order.getDate());
        stmt.setBigDecimal(3, order.getCust());
        stmt.setBigDecimal(4,order.getRep());
        stmt.setString(5,order.getMfr());
        stmt.setString(6, order.getProduct() != null ? order.getProduct().getProduct_id() : null);
        stmt.setBigDecimal(7, order.getQty());
        stmt.setBigDecimal(8, order.getAmount());
    }

    public static void setOfficeValuesToStatement (Offices office, PreparedStatement stmt) throws SQLException {
        stmt.setBigDecimal(1, office.getOffice());
        stmt.setString(2, office.getCity());
        stmt.setString(3, office.getRegion());
        stmt.setBigDecimal(4, office.getMgr());
        stmt.setBigDecimal(5,office.getTarget());
        stmt.setBigDecimal(6, office.getSales());
    }
}
