package lesson21;

import javax.persistence.EntityManager;

public interface DAOTemplate {
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
