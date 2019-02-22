package lesson21;

import lesson17.models.Orders;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Set;


public class OrderDAOImpl implements OrderDAO {

    private static EntityManagerFactory factory;

    static {
        Locale.setDefault(Locale.ENGLISH);
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private EntityManager entityManager = factory.createEntityManager();

    @Override
    public Set<Order> getAllOrdersJoin() throws SQLException {
        return null;
    }

    @Override
    public Set<Order> getAllOrders() throws SQLException {
        return null;
    }

    @Override
    public Order findOrderById(BigDecimal id) throws SQLException {
        return null;
    }

    @Override
    public boolean insertOrder(Order order) throws SQLException {
        OrderDAOTemplate dao = (entMgr) -> entMgr.persist(order);
        return dao.template(entityManager);
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        OrderDAOTemplate dao = (entMgr) -> entMgr.merge(order);
        return dao.template(entityManager);
    }
    
    @Override
    public boolean deleteOrder(BigDecimal id) throws SQLException {
        OrderDAOTemplate dao = (entMgr) -> entMgr.remove(entityManager.find(Order.class, id));
        return dao.template(entityManager);
    }
}
