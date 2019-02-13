package lesson17;

import lesson17.models.Orders;
import lesson17.models.Products;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public Set<Orders> getAllOrders() throws SQLException {
        return null;
    }

    @Override
    public Set<Orders> getAllOrders2() throws SQLException {
        return null;
    }

    @Override
    public Orders findOrderById(BigDecimal id) throws SQLException {
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from orders\n" +
                "inner join products on product_id = product\n" +
                "where order_num = ?");
        stmt.setBigDecimal(1, id);
        ResultSet rs = stmt.executeQuery();

        Orders order = null;
        if (rs.next()) {
            order = new Orders(rs.getBigDecimal("order_num"), rs.getDate("order_date"),
                    rs.getBigDecimal("CUST"), rs.getBigDecimal("rep"),
                    rs.getString("mfr"),
                    rs.getBigDecimal("qty"), rs.getBigDecimal("amount"), new Products(rs.getString("MFR_ID"), rs.getString("PRODUCT_ID"),
                    rs.getString("DESCRIPTION"), rs.getBigDecimal("PRICE"), rs.getBigDecimal("QTY_ON_HAND")));
        }

        rs.close();
        stmt.close();
        conn.close();
        return order;
    }

    @Override
    public boolean insertOrder(Orders order) throws SQLException {
        return false;
    }

    @Override
    public boolean updateOrder(Orders order) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOrder(Orders order) throws SQLException {
        return false;
    }
}
