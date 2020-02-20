package main;

import oneToMAny.UserDetails;
import oneToMAny.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sessionFactory.SessionFactoryHolder;

public class UserDetailsOneToManyMainClass {
    public static void main(String[] args) {
        UserDetailsOneToManyMainClass mainClass = new UserDetailsOneToManyMainClass();


        SessionFactory sessionFactory = SessionFactoryHolder.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        UserDetails userDetails = mainClass.prepareUserData();
        Vehicle vehicleData = mainClass.prepareVehicleData();
        Vehicle vehicleData2 = mainClass.prepareVehicleData2();
        userDetails.getVehicle().add(vehicleData);
        vehicleData2.setUserDetails(userDetails);// for biderectional relationship
        vehicleData.setUserDetails(userDetails); // for biderectional relationship
        userDetails.getVehicle().add(vehicleData2);
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
    private Vehicle prepareVehicleData2() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("maruti");
        return vehicle;
    }

    private UserDetails prepareUserData() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName("reema");


        return userDetails;
    }
}
