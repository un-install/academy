package lesson21;

import lesson17.models.Orders;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public interface OrderDAO {
    Set<Order> getAllOrdersJoin();
    Set<Order> getAllOrders();
    Order findOrderById(BigDecimal id);
    boolean insertOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(BigDecimal id);
}
