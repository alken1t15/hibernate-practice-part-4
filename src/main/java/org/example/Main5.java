package org.example;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main5 {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<User> criteriaDelete = criteriaBuilder.createCriteriaDelete(User.class);
        Root<User> root = criteriaDelete.getRoot();
        criteriaDelete.where(criteriaBuilder.equal(root.get("id"),10514));

        Transaction transaction = session.beginTransaction();
     //   session.createQuery(criteriaDelete).executeUpdate(); Старый вариант
        session.createMutationQuery(criteriaDelete).executeUpdate();
        transaction.commit();


        session.close();
        HibernateUtil.shutdown();
    }
}
