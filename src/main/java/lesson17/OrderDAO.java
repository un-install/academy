package lesson17;


import lesson17.models.Orders;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public interface OrderDAO {
    Set<Orders> getAllOrders() throws SQLException;
    Set<Orders> getAllOrders2() throws SQLException;
    Orders findOrderById(BigDecimal id) throws SQLException;
    boolean insertOrder(Orders order) throws SQLException;
    boolean updateOrder(Orders order) throws SQLException;
    boolean deleteOrder(Orders order) throws SQLException;
}
