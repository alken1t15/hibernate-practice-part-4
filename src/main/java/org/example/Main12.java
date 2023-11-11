package org.example;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main12 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<User> query = session.createQuery("select new User (u.id,u.email) FROM User u", User.class);

        List<User> users = query.getResultList();

        users.forEach(user -> {
            System.out.println(user.getEmail());
            System.out.println(" ");
            System.out.println(user.getId());
        });
    }
}
