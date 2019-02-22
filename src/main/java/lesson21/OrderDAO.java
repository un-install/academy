package lesson21;

import lesson17.models.Orders;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public interface OrderDAO {
    Set<Orders> getAllOrdersJoin() throws SQLException;
    Set<Orders> getAllOrders() throws SQLException;
    Orders findOrderById(BigDecimal id) throws SQLException;
    boolean insertOrder(Order order) throws SQLException;
    boolean updateOrder(Order order) throws SQLException;
    boolean deleteOrder(BigDecimal id) throws SQLException;
}
