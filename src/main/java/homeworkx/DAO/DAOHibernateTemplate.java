package homeworkx.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface DAOHibernateTemplate {
    default boolean hiberTemplate(SessionFactory sf){
        Session session = null;
        try{
             session = sf.openSession();
            session.beginTransaction();
            dbOperation(session);
            session.getTransaction().commit();
            return true;
        }catch (Exception sqlException){
            if (session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    void dbOperation(Session session);
}
