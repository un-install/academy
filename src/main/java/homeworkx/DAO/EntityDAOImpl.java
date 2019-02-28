package homeworkx.DAO;

import homeworkx.models.ModelInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Locale;
import java.util.Set;


public class EntityDAOImpl<K extends ModelInterface> implements EntityDAO<K> {

    private final Class<K> type;
    private static EntityManagerFactory factory;

    static {
        Locale.setDefault(Locale.ENGLISH);
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private EntityManager entityManager = factory.createEntityManager();

    public EntityDAOImpl(Class<K> type) {
        this.type = type;
    }

    @Override
    public Set<K> getAllEntities() {
        return null;
    }

    @Override
    public<T> K findEntityById(T id) throws IllegalAccessException, InstantiationException {
        K o = type.newInstance();
        DAOTemplate dao = (entMgr) -> o.setAll(entMgr.find(type, id));
        dao.template(entityManager);
        return o;
    }

    @Override
    public boolean insertEntity(K entity) {
        DAOTemplate dao = (entMgr) -> entMgr.persist(entity);
        return dao.template(entityManager);
    }

    @Override
    public boolean updateEntity(K entity) {
        DAOTemplate dao = (entMgr) -> entMgr.merge(entity);
        return dao.template(entityManager);
    }

    @Override
    public <T> boolean deleteEntity(T id) {
        K o = (entityManager.find(type, id));
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
