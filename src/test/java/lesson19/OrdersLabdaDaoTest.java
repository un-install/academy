package lesson19;

import lesson17.models.Orders;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import static lesson17.OJDBCUtils.getConnection;
import static lesson19.template.OrdersLabdaDao.*;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdersLabdaDaoTest {
    private final Orders INSERT_ORDER = new Orders(new BigDecimal(1111111113),
            new Date(2019, 12, 2),new BigDecimal(2102),
            new BigDecimal(101), "asd", null, null, null);

    private final Orders UPDATE_ORDER = new Orders( new BigDecimal(1111111113),
            null,new BigDecimal(2102), new BigDecimal(104), "asd",
            new BigDecimal(222), new BigDecimal(222), null);

    @Test
    public void test1InsertOrder() throws SQLException {
        assertTrue(insertOrder(INSERT_ORDER, getConnection()));
    }

    @Test
    public void test2UpdateOrder() throws SQLException {
        assertTrue(updateOrder(UPDATE_ORDER, getConnection()));
    }

    @Test
    public void test3DeleteOrder() throws SQLException {
        assertTrue(deleteOrder(INSERT_ORDER, getConnection()));
    }

}
