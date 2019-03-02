package homeworkx.DAO;

import homeworkx.models.ModelInterface;

import java.math.BigDecimal;
import java.util.Set;

public interface EntityDAO<K> {
    public Set<K> getAllEntities();
    public <T> K findEntityById(T id) throws IllegalAccessException, InstantiationException;
    public boolean insertEntity(K entity);
    public boolean updateEntity(K entity);
    public <T> boolean deleteEntity(T id);
}
