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
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from orders\n" +
                "inner join products on product_id = product\n");
        ResultSet rs = stmt.executeQuery();

        Set<Orders> orders = new HashSet<>();
        while (rs.next()) {
            orders.add(OJDBCUtils.newOrderByRs(rs, OJDBCUtils.newProductByRs(rs)));
        }
        OJDBCUtils.closeAllCloseble(rs, stmt, conn);
        return orders;
    }

    @Override
    public Set<Orders> getAllOrders2() throws SQLException {
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from orders");
        ResultSet rs = stmt.executeQuery();
        PreparedStatement stmtProduct = conn.prepareStatement("select* from products where product_id = ?");
        ResultSet rsProduct = null;

        Set<Orders> orders = new HashSet<>();
        Products product = null;
        while (rs.next()) {
            stmtProduct.setString(1, rs.getString("PRODUCT"));
            rsProduct = stmtProduct.executeQuery();
            if (rsProduct.next()){
                product = OJDBCUtils.newProductByRs(rsProduct);
            }
            orders.add(OJDBCUtils.newOrderByRs(rs, product));
        }
        OJDBCUtils.closeAllCloseble(rs, stmt, rsProduct, stmtProduct, conn);
        return orders;
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
            order = OJDBCUtils.newOrderByRs(rs, OJDBCUtils.newProductByRs(rs));
        }
        OJDBCUtils.closeAllCloseble(rs, stmt, conn);
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
