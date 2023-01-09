package by.itclass.model.db.hibernate;

import by.itclass.model.beans.Image;
import by.itclass.model.beans.News;
import by.itclass.model.beans.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManager {
    private static SessionFactory sessionFactory;
    private static Configuration configuration;

    static {
        configuration=new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(News.class);
        configuration.addAnnotatedClass(Image.class);
        sessionFactory=configuration.buildSessionFactory();

    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }

}
