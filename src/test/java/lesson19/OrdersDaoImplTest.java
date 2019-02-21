package lesson19;

import lesson17.models.Orders;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import lesson19.template.OrdersDaoImpl.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdersDaoImplTest {
    private final Orders INSERT_ORDER = new Orders(new BigDecimal(1111111113),
            new Date(2019, 12, 2),new BigDecimal(2102),
            new BigDecimal(101), "asd", null, null, null);

    private final Orders UPDATE_ORDER = new Orders( new BigDecimal(1111111113),
            null,new BigDecimal(2102), new BigDecimal(104), "asd",
            new BigDecimal(222), new BigDecimal(222), null);


    @Test
    public void test1InsertOrder() throws SQLException {
        OrderInsert ori = new OrderInsert();
        assertTrue(ori.template(INSERT_ORDER));
    }

    @Test
    public void test2UpdateOrder() throws SQLException {
        OrderUpdate ori = new OrderUpdate();
        assertTrue(ori.template(UPDATE_ORDER));
    }

    @Test
    public void test3DeleteOrder() throws SQLException {
        OrderDelete ori = new OrderDelete();
        assertTrue(ori.template(INSERT_ORDER));
    }
}
