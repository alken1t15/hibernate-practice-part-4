package org.example;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Main11 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Long> query = session.createQuery("select count(u.id) from User u where u.email like :text", Long.class);
        query.setParameter("text","%email%");
        Long count = query.uniqueResult();
        System.out.println(count);
    }
}
