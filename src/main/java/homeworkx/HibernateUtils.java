package homeworkx;

import homeworkx.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.util.Locale;

public class HibernateUtils {
    private static File cfg = new File("src\\main\\resources\\hibernate.cfg.xml");

    public static SessionFactory buildSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);

        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(Order.class);
        configObj.addAnnotatedClass(Customer.class);
        configObj.addAnnotatedClass(Office.class);
        configObj.addAnnotatedClass(Products.class);
        configObj.addAnnotatedClass(Salesrep.class);
        configObj.configure(cfg);

        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
                .applySettings(configObj.getProperties()).build();

        return configObj.buildSessionFactory(serviceRegistryObj);
    }
}
