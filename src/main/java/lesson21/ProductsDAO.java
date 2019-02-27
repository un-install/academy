package lesson21;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Locale;

public class ProductsDAO {
    private static EntityManagerFactory factory;

    static {
        Locale.setDefault(Locale.ENGLISH);
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private EntityManager entityManager = factory.createEntityManager();
    public Products findBroductsById(String id) {
        Products p = new Products();
        DAOTemplate dao = (entMgr) -> p.setAll(entMgr.find(Products.class, id));
        dao.template(entityManager);
        return p;
    }
}
