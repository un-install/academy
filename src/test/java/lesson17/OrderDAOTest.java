package lesson17;

import lesson17.models.Orders;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
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

    @Test
    public void testInsertOrder() throws SQLException {
        assertTrue(dao.insertOrder(new Orders(new BigDecimal(1111111113),
                new Date(2019, 12, 2),new BigDecimal(2102), new BigDecimal(101), "asd", null, null, null)));
    }

    @Test
    public void testUpdateOrder() throws SQLException {
        assertTrue(dao.updateOrder(new Orders( new BigDecimal(1111111113),
                null,new BigDecimal(2102), new BigDecimal(104), "asd", new BigDecimal(222), new BigDecimal(222), null)));
    }

    @Test
    public void testDelete() throws SQLException {
        assertTrue(dao.deleteOrder(new Orders( BigDecimal.valueOf(1111111113),
                null,new BigDecimal(2102), new BigDecimal(104), "asd", new BigDecimal(222), new BigDecimal(222), null)));
    }

}
