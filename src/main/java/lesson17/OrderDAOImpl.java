package lesson17;

import lesson17.models.Orders;
import lesson17.models.Products;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import static lesson17.OJDBCUtils.setStatmentOrderValues;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public Set<Orders> getAllOrdersJoin() throws SQLException {
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from orders\n" +
                "inner join products on product_id = product\n");
        ResultSet rs = stmt.executeQuery();

        Set<Orders> orders = new HashSet<>();
        while (rs.next()) {
            orders.add(OJDBCUtils.newOrderByResultSet(rs, OJDBCUtils.newProductByResultSet(rs)));
        }
        OJDBCUtils.closeAllCloseble(rs, stmt, conn);
        return orders;
    }

    @Override
    public Set<Orders> getAllOrders() throws SQLException {
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
                product = OJDBCUtils.newProductByResultSet(rsProduct);
            }
            orders.add(OJDBCUtils.newOrderByResultSet(rs, product));
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

        getMeta(rs);

        Orders order = null;
        if (rs.next()) {
            order = OJDBCUtils.newOrderByResultSet(rs, OJDBCUtils.newProductByResultSet(rs));
        }
        OJDBCUtils.closeAllCloseble(rs, stmt, conn);
        return order;
    }

    @Override
    public boolean insertOrder(Orders order) throws SQLException {
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into orders(ORDER_NUM,ORDER_DATE ,CUST, REP, MFR, PRODUCT, QTY, AMOUNT)" +
                " values(?, ?, ?, ?, ?, ?, ?, ?)");

        setStatmentOrderValues(stmt, order);

        boolean rt = stmt.executeUpdate() == 1;
        OJDBCUtils.closeAllCloseble(conn, stmt);
        return rt;
    }

    @Override
    public boolean updateOrder(Orders order) throws SQLException {
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement("update orders set order_num = ?, order_date = ?, cust = ?, rep = ?," +
                " mfr = ?, product = ?, qty = ?, amount = ? where order_num = ?");

        setStatmentOrderValues(stmt, order);
        stmt.setBigDecimal(9, order.getOrderNum());

        boolean rt = stmt.executeUpdate() == 1;
        OJDBCUtils.closeAllCloseble(conn, stmt);
        return rt;
    }

    @Override
    public boolean deleteOrder(Orders order) throws SQLException {
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement("delete  orders  where order_num = ?");


        stmt.setBigDecimal(1, order.getOrderNum());

        boolean rt = stmt.executeUpdate() == 1;
        OJDBCUtils.closeAllCloseble(conn, stmt);
        return rt;
    }

    private void getMeta(ResultSet rs) throws SQLException {
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++){
            System.out.println("___________________");
            System.out.print(resultSetMetaData.getColumnName(i) + ", ");
            System.out.print(resultSetMetaData.getColumnType(i) + ", ");
            System.out.println(resultSetMetaData.getColumnClassName(i) + ", ");
            System.out.println(resultSetMetaData.getColumnTypeName(i));
        }
    }
}