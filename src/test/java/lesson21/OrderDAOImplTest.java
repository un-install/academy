package lesson21;

import lesson17.models.Orders;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDAOImplTest {
    private OrderDAO dao = new OrderDAOImpl();
    private final Order INSERT_ORDER = new Order(new BigDecimal(1111111114),
            new Date(2019, 12, 2),new BigDecimal(2102),
            new BigDecimal(101), "asd", new BigDecimal(108), new BigDecimal(222), null);

    private final Order UPDATE_ORDER = new Order( new BigDecimal(1111111113),
            null,new BigDecimal(2102), new BigDecimal(104), "asd",
            new BigDecimal(222), new BigDecimal(222), null);

    @Test
    public void test1InsertOrder(){
        assertTrue(dao.insertOrder(INSERT_ORDER));
    }

    @Test
    public void test2UpdateOrder(){
        assertTrue(dao.updateOrder(UPDATE_ORDER));
    }

    @Test
    public void test3DeleteOrder(){
        assertTrue(dao.deleteOrder(INSERT_ORDER.getOrderNum()));
    }

}
