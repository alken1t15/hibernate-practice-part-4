package org.example;

import org.example.entity.Category;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main17 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Category> query = session.createQuery("from Category ", Category.class);
        query.setMaxResults(10);

        List<Category> categories = query.getResultList();

        System.out.println(categories.get(0).getUser());


        session.close();
    }
}
