package com.mond.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by User on 19.11.2017.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        return new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown(){
        sessionFactory.close();
    }
}
