package lesson17;

import lesson17.models.Orders;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class OrderDAOTest {
    private OrderDAOImpl dao = new OrderDAOImpl();
    private static final BigDecimal id = new BigDecimal(113042);

    @Test
    public void testGetAllOrdersJoin() throws SQLException {
        Set<Orders> actual = dao.getAllOrdersJoin();
        assertTrue(actual.size() > 0);
    }

    @Test
    public void testGetAllOrders() throws SQLException {
        Set<Orders> actual = dao.getAllOrders();
        assertTrue(actual.size() > 0);
    }

    @Test
    public void testFindOrderById() throws SQLException {
        Orders actual = dao.findOrderById(id);
        assertNotNull(actual);
    }
}
