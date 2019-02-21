package lesson19.template;

import lesson17.OJDBCUtils;
import lesson17.models.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrdersLabdaDao {
    public static boolean insertOrder(Orders order, Connection connection) {
        System.out.println("Inserting to Orders...");
        DaoFunctionalInterface daoi = (conn) -> {
            PreparedStatement stmt = conn.prepareStatement("insert into orders(ORDER_NUM,ORDER_DATE ,CUST, REP, MFR, PRODUCT, QTY, AMOUNT)" +
                    " values(?, ?, ?, ?, ?, ?, ?, ?)");

            OJDBCUtils.setStatmentOrderValues(stmt, order);
            return stmt;
        };

        return daoi.template(connection);
    }

    public static boolean updateOrder(Orders order, Connection connection) {
        System.out.println("Updating Orders...");
        DaoFunctionalInterface daoi = (conn) ->{
            PreparedStatement stmt = conn.prepareStatement("update orders set order_num = ?, order_date = ?, cust = ?, rep = ?," +
                    " mfr = ?, product = ?, qty = ?, amount = ? where order_num = ?");

            OJDBCUtils.setStatmentOrderValues(stmt, order);
            stmt.setBigDecimal(9, order.getOrderNum());
            return stmt;
        };

        return daoi.template(connection);
    }

    public static boolean deleteOrder(Orders order, Connection connection) {
        System.out.println("Deleting form Orders...");
        DaoFunctionalInterface daoi = (conn) -> {
            PreparedStatement stmt = conn.prepareStatement("delete  orders  where order_num = ?");
            stmt.setBigDecimal(1, order.getOrderNum());
            return stmt;
        };

        return daoi.template(connection);
    }
}
