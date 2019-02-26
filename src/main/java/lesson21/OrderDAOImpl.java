package lesson21;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
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
    public Set<Order> getAllOrdersJoin() {
        return null;
    }

    @Override
    public Set<Order> getAllOrders() {
        return null;
    }

    @Override
    public Order findOrderById(BigDecimal id) {
        return null;
    }

    @Override
    public boolean insertOrder(Order order) {
        DAOTemplate dao = (entMgr) -> entMgr.persist(order);
        return dao.template(entityManager);
    }

    @Override
    public boolean updateOrder(Order order) {
        DAOTemplate dao = (entMgr) -> entMgr.merge(order);
        return dao.template(entityManager);
    }
    
    @Override
    public boolean deleteOrder(BigDecimal id) {
        Order o = entityManager.find(Order.class, id);
        if (o != null) {
            DAOTemplate dao = (entMgr) -> entMgr.remove(o);
            return dao.template(entityManager);
        }
        else{
            System.out.println("entity with that id not found");
            return false;
        }
    }
}
