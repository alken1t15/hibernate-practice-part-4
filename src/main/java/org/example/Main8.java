package org.example;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main8 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<User> query = session.createQuery("FROM User u where u.email like :text", User.class);
        query.setParameter("text","%a%");
        List<User> users = query.getResultList();

        System.out.println(users);
    }
}
