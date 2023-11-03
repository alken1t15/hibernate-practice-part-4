package org.example;

import org.hibernate.Session;

import javax.management.Query;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

     //   Query query = session.createQuery("select u from ");

        session.close();
        HibernateUtil.shutdown();
    }
}