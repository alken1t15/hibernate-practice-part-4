package org.example;


import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Main10 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<User> query = session.createQuery("from User where id =:id", User.class);
        query.setParameter("id",10025L);

        User user = query.uniqueResult();

        System.out.println(user);
    }
}
