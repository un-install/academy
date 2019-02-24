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
    public Set<Office> getAllOffices() throws SQLException {
        return null;
    }

    @Override
    public Set<Office> getOfficesByRegion(String region) throws SQLException {
        return null;
    }

    @Override
    public boolean insertOffice(Office office) throws SQLException {
        DAOTemplate dao = (entMgr) -> entMgr.persist(office);
        return dao.template(entityManager);
    }

    @Override
    public boolean updateOffice(Office office) throws SQLException {
        DAOTemplate dao = (entMgr) -> entMgr.merge(office);
        return dao.template(entityManager);
    }

    @Override
    public boolean deleteOffice(BigDecimal id) throws SQLException {
        DAOTemplate dao = (entMgr) -> entMgr.remove(entityManager.find(Office.class, id));
        return dao.template(entityManager);
    }
}
