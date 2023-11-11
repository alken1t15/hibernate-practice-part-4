package org.example;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class Main14 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNativeQuery("select count(u.id), substring(u.email, position('@' in u.email)+1," +
                "length(u.email)) as domainemail from todolist.user_data u where u.email like '%@%' " +
                "group by substring(u.email, position('@' in u.email)+1,length(u.email))");


        for (Object obj : query.getResultList()){
            Object[] objects = (Object[]) obj;
            System.out.println(objects[0]);
            System.out.println(objects[1]);
        }

//        NativeQuery<Object[]> query = session.createNativeQuery("select count(u.id), substring(u.email, position('@' in u.email)+1," +
//                "length(u.email)) as domainemail from todolist.user_data u where u.email like '%@%' " +
//                "group by substring(u.email, position('@' in u.email)+1,length(u.email))",Object[].class);
//
//        for (Object[] obj : query.getResultList()){
//            System.out.println(obj[0]);
//            System.out.println(obj[1]);
//        }

        session.close();
    }
}
