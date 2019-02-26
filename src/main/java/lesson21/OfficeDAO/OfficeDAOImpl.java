package lesson21.OfficeDAO;

import lesson21.DAOTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Set;

public class OfficeDAOImpl implements OfficeDAO {
    private static EntityManagerFactory factory;

    static {
        Locale.setDefault(Locale.ENGLISH);
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private EntityManager entityManager = factory.createEntityManager();

    @Override
    public Set<Office> getAllOffices() {
        return null;
    }

    @Override
    public Set<Office> getOfficesByRegion(String region){
        return null;
    }

    @Override
    public boolean insertOffice(Office office) {
        DAOTemplate dao = (entMgr) -> entMgr.persist(office);
        return dao.template(entityManager);
    }

    @Override
    public boolean updateOffice(Office office){
        DAOTemplate dao = (entMgr) -> entMgr.merge(office);
        return dao.template(entityManager);
    }

    @Override
    public boolean deleteOffice(BigDecimal id) {
        Office o = entityManager.find(Office.class, id);
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
