package main;

import dao.Address;
import onetoOne.UserDetails;
import onetoOne.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sessionFactory.SessionFactoryHolder;

import java.util.Date;

public class UserDetailsOneToOneMainClass {
    public static void main(String[] args) {
        UserDetailsOneToOneMainClass mainClass = new UserDetailsOneToOneMainClass();


        SessionFactory sessionFactory = SessionFactoryHolder.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserDetails userDetails = mainClass.prepareUserData();
        Vehicle vehicleData = mainClass.prepareVehicleData();
        userDetails.setVehicle(vehicleData);
        session.save(userDetails);
        session.save(vehicleData);
        transaction.commit();
        session.close();

        session = sessionFactory.openSession();
        UserDetails userDetails1 = (UserDetails) session.get(UserDetails.class, 1); // returns proxy object here
        //session.close();// we do this to check if it is a proxy object or real object if session is close the we
        // can't fetch the value so we get LazyInitializationException
        sessionFactory.close();


    }

    private Vehicle prepareVehicleData() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("toyota");
        return vehicle;
    }

    private UserDetails prepareUserData() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("reema");


        return userDetails;
    }
}
