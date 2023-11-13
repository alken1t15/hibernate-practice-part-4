package org.example;

import org.example.entity.Category;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main18 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<User> query = session.createQuery("from User ", User.class);
        query.setMaxResults(10);

        List<User> users = query.getResultList();

        System.out.println(users.get(0));


        session.close();
    }
}
