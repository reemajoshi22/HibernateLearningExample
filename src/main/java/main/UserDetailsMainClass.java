package main;

import dao.Address;
import dao.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sessionFactory.SessionFactoryHolder;

import java.util.Date;

public class UserDetailsMainClass {
    public static void main(String[] args) {
        UserDetailsMainClass mainClass=new UserDetailsMainClass();


        SessionFactory sessionFactory= SessionFactoryHolder.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserDetails userDetails = mainClass.prepareUserData();
        session.save(userDetails);
        transaction.commit();
        session.close();

        session=sessionFactory.openSession();
        UserDetails userDetails1 = (UserDetails) session.get(UserDetails.class, 1); // returns proxy object here
        //session.close();// we do this to check if it is a proxy object or real object if session is close the we
        // can't fetch the value so we get LazyInitializationException
        System.out.println(userDetails1.getAddress().size());
        sessionFactory.close();



    }

    private UserDetails prepareUserData() {
        UserDetails userDetails=new UserDetails();
        userDetails.setId(1);
        userDetails.setName("reema");
        userDetails.setPhone("9599937146");
        userDetails.setDob(new Date());

        Address address1=new Address();
        address1.setCity("noida");
        address1.setPincode("201301");
        address1.setState("UP");
        address1.setStreet("indosam");
        userDetails.getAddress().add(address1);
        //userDetails.setHomeAddress(address1);

        Address address2=new Address();
        address2.setCity("noida");
        address2.setPincode("201301");
        address2.setState("UP");
        address2.setStreet("newgen");
        userDetails.getAddress().add(address2);
        //userDetails.setHomeAddress(address2);

    return userDetails;}
}
