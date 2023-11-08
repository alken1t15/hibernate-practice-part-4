package org.example;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.entity.User;
import org.hibernate.Session;

import javax.swing.plaf.LabelUI;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);

        Query query = session.createQuery(criteriaQuery);
        List<User> results = query.getResultList();

        session.getTransaction().commit();

        session.close();
        HibernateUtil.shutdown();
    }
}
