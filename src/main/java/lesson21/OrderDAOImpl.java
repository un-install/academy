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
    public Set<Orders> getAllOrdersJoin() throws SQLException {
        return null;
    }

    @Override
    public Set<Orders> getAllOrders() throws SQLException {
        return null;
    }

    @Override
    public Orders findOrderById(BigDecimal id) throws SQLException {
        return null;
    }

    @Override
    public boolean insertOrder(Order order) throws SQLException {
        OrderDAOTemplate dao = (entMgr) -> entMgr.persist(order);
        return dao.template(entityManager);
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOrder(BigDecimal id) throws SQLException {
        return false;
    }
}
