package homeworkx.DAO;

import homeworkx.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class HibernateEntityDAOImpl<K extends ModelInterface> implements EntityDAO<K> {
    private final Class<K> type;
    private SessionFactory sessionFactory;

    public HibernateEntityDAOImpl(Class<K> type, SessionFactory sessionFactory) {
        this.type = type;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Set<K> getAllEntities() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<K> cq = cb.createQuery(type);
            Root<K> rootEntry = cq.from(type);
            CriteriaQuery<K> all = cq.select(rootEntry);
            TypedQuery<K> allQuery = session.createQuery(all);

            return new HashSet<>(allQuery.getResultList());
        } catch (RuntimeException e){
            throw e;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public <T extends Serializable> K findEntityById(T id) throws IllegalAccessException, InstantiationException {
        K entity = type.newInstance();
        DAOHibernateTemplate dao = (session -> entity.setAll(session.get(type, id)));
        dao.hiberTemplate(sessionFactory);
        return entity;
    }

    @Override
    public boolean insertEntity(K entity) {
        DAOHibernateTemplate dao = session -> session.persist(entity);
        return dao.hiberTemplate(sessionFactory);
    }

    @Override
    public boolean updateEntity(K entity) {
        DAOHibernateTemplate dao = session -> session.merge(entity);
        return dao.hiberTemplate(sessionFactory);
    }

    public boolean deleteEntity(K entity) {
        DAOHibernateTemplate dao = session -> session.delete(entity);
        return dao.hiberTemplate(sessionFactory);
    }
}
