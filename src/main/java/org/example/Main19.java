package org.example;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main19 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<User> query = session.createQuery("from User ", User.class);
        query.setMaxResults(2);

        List<User> users = query.getResultList();

        System.out.println(users.get(0).getRoles());

        session.close();
    }
}
