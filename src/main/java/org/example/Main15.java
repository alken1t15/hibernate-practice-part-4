package org.example;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Main15 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        User user = session.get(User.class, 10034L);

        System.out.println(user);

        session.close();
    }
}
