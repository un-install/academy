package homeworkx;

import lesson21.Order;

import java.math.BigDecimal;
import java.util.Set;

public interface OrderDAO {
    Set<Order> getAllOrdersJoin();
    Set<Order> getAllOrders();
    Order findOrderById(BigDecimal id);
    boolean insertOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(BigDecimal id);
}
