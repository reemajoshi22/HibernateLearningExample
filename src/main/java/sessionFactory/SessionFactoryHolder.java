package sessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class SessionFactoryHolder {

    private static SessionFactory factory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        if(factory==null){
            Configuration configuration=new Configuration().configure("hibernate_learning.cfg.xml");
            StandardServiceRegistry standardServiceRegistry= new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(standardServiceRegistry);
        }
        return factory;
    }
}
