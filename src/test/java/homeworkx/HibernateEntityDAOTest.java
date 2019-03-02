package homeworkx;

import homeworkx.DAO.HibernateEntityDAOImpl;
import homeworkx.models.Order;
import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HibernateEntityDAOTest {
    private final SessionFactory sf = HibernateUtils.buildSessionFactory();
    private HibernateEntityDAOImpl<Order> odao = new HibernateEntityDAOImpl<>(Order.class, sf);

    private final Order INSERT_ORDER = new Order(new BigDecimal(1111111114),
            new Date(2019, 12, 2),null ,
            null, "asd", new BigDecimal(1111), new BigDecimal(222), null);

    private final Order UPDATE_ORDER = new Order(new BigDecimal(1111111114),
            new Date(2017, 12, 2),null ,
            null, "dsa", new BigDecimal(2222), new BigDecimal(22211), null);


    @Test
    public void testFindById() throws InstantiationException, IllegalAccessException {
        Order p = odao.findEntityById(new BigDecimal(113048));
        System.out.println(p);
        assertNotNull(p);
    }

    @Test
    public void testFindAll() {
        Set<Order> orders = odao.getAllEntities();
        orders.forEach(System.out::println);
        assertTrue(orders.size() >= 0);
    }

    @Test
    public void test1Insert(){
        assertTrue(odao.insertEntity(INSERT_ORDER));
    }

    @Test
    public void test2Update(){
        assertTrue(odao.updateEntity(UPDATE_ORDER));
    }
    @Test
    public void test3Delete(){
        assertTrue(odao.deleteEntity(INSERT_ORDER));
    }
}
