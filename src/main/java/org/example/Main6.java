package org.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main6 {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<User> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(User.class);
        Root<User> root = criteriaUpdate.getRoot();

        criteriaUpdate.set("email","test@email.com");
        criteriaUpdate.where(criteriaBuilder.equal(root.get("id"),10515));

        Transaction transaction = session.beginTransaction();
        //   session.createQuery(criteriaDelete).executeUpdate(); Старый вариант
        session.createMutationQuery(criteriaUpdate).executeUpdate();
        transaction.commit();


        session.close();
        HibernateUtil.shutdown();
    }
}