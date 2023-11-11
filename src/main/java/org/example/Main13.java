package org.example;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;


public class Main13 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String qry = "select * from todolist.user_data";
        NativeQuery nativeQuery = session.createNativeQuery(qry);
        nativeQuery.setMaxResults(30);
        nativeQuery.addEntity(User.class);


       List<User> users = nativeQuery.list();
       users.stream().forEach(user -> {
           System.out.println(user.getId());
       });
    }
}
