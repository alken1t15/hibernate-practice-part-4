package org.example;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main9 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<User> query = session.createQuery("FROM User", User.class);
        query.setFirstResult(1);
        query.setMaxResults(10);
        List<User> users = query.getResultList();

        System.out.println(users);
    }
}
