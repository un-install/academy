package lesson19.template;

import lesson17.OJDBCUtils;
import lesson17.models.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdersDaoImpl {
    public static class OrderInsert extends abstractDao {

        @Override
        public <K> PreparedStatement updateTable(K tableObj, Connection conn) throws SQLException {
            Orders order = (Orders) tableObj;
            PreparedStatement stmt = conn.prepareStatement("insert into orders(ORDER_NUM,ORDER_DATE ,CUST, REP, MFR, PRODUCT, QTY, AMOUNT)" +
                    " values(?, ?, ?, ?, ?, ?, ?, ?)");

            OJDBCUtils.setStatmentOrderValues(stmt, order);
            return stmt;
        }
    }

    public static class OrderUpdate extends abstractDao {

        @Override
        public <K> PreparedStatement updateTable(K tableObj, Connection conn) throws SQLException {
            Orders order = (Orders) tableObj;
            PreparedStatement stmt = conn.prepareStatement("update orders set order_num = ?, order_date = ?, cust = ?, rep = ?," +
                    " mfr = ?, product = ?, qty = ?, amount = ? where order_num = ?");

            OJDBCUtils.setStatmentOrderValues(stmt, order);
            stmt.setBigDecimal(9, order.getOrderNum());
            return stmt;
        }
    }

    public static class OrderDelete extends abstractDao {

        @Override
        public <K> PreparedStatement updateTable(K tableObj, Connection conn) throws SQLException {
            Orders order = (Orders) tableObj;
            PreparedStatement stmt = conn.prepareStatement("delete  orders  where order_num = ?");

            stmt.setBigDecimal(1, order.getOrderNum());
            return stmt;
        }
    }
}
