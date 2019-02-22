package lesson21;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;

public interface OrderDAOTemplate {
    default boolean template(EntityManager entityManager){

        try {
            entityManager.getTransaction().begin();
            makeUpdate(entityManager);
            entityManager.getTransaction().commit();
            return true;
        }catch (RuntimeException e){
            if (entityManager != null) {
                System.out.println("Transaction rollback");
            }
            throw e;
        }
    }

    void makeUpdate(EntityManager e);
}
