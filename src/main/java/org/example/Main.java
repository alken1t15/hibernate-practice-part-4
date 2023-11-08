package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entity.User;
import org.hibernate.Session;

import javax.management.Query;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        User user = new User();
        user.setEmail("fsdfsfddf5@email.com");
        user.setUsername("Papfder");
        user.setPassword("45435gffdg");

        session.persist(user);

        session.getTransaction().commit();

        System.out.println("user = " + user.getId());

        session.close();
        HibernateUtil.shutdown();
    }
}