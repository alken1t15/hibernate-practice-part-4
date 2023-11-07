package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.concurrent.ExecutionException;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            return new Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
        }catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            buildSessionFactory();
        }
        return sessionFactory;
    }
    public static void shutdown(){
        getSessionFactory().close();
    }

}
