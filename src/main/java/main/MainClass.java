package main;

import dao.Manufacturer;
import dao.OS;
import dao.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sessionFactory.SessionFactoryHolder;

public class MainClass {
    public static void main(String[] args) {
        MainClass mainClass=new MainClass();
        
        
        SessionFactory sessionFactory= SessionFactoryHolder.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Phone phone = mainClass.preparePhoneInsertData();
        //Phone phone1 = mainClass.preparePhoneInsertData();
        session.save(phone);
        //session.save(phone1);
        System.out.println("---data inserted---");

        transaction.commit();

        /**
         * load data from database using load() method
         * // For loading Transaction scope is not necessary
         *
         * we have 2 methods to load the object from the database, they are load and get
         */

        Object o = session.load(Phone.class, new Integer(1));
        Phone p=(Phone)o;
        System.out.println("loading the data from database of phone model and phone id : "+p.getPhone_model() +" "+p.getPhone_id());

        /**
         * delete the data
         *
         * we have only one method to delete an object from the database
         */

        Transaction deleteTransaction=session.beginTransaction();
        session.delete(p);
        System.out.println("Delete the data from database using delete method and the id of deleted phone is :"+p.getPhone_id());
        deleteTransaction.commit();

        // delete data

         /* Transaction transaction2 = session.beginTransaction(); Phone
          prepareUpdateData = mainClass.prepareUpdateData();
          session.delete(prepareUpdateData);
          transaction2.commit();*/


        // updating data

          /*Transaction transaction3 = session.beginTransaction();
          Phone updateData1 = mainClass.prepareUpdateData();
          session.update(updateData1);
          transaction3.commit();*/
        sessionFactory.close();



    }

    private Phone prepareUpdateData() {
        Phone phone = new Phone();
        phone.setPhone_id(145);
        phone.setSim_slots("18");
        phone.setPhone_model("nokia11");

        OS os = new OS();
        os.setOs_id(40);
        os.setOs_name("androidd");
        phone.setOs(os);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturer_id(41);
        manufacturer.setManufacturername("nokiaa");
        manufacturer.setCountry("india");
        phone.setManufacturer(manufacturer);

        return phone;

    }


    private Phone preparePhoneInsertData() {
        Phone phone = new Phone();
        phone.setPhone_id(125);

        phone.setSim_slots("2");
        phone.setPhone_model("nokia11");

        OS os = new OS();
        os.setOs_id(228);
        os.setOs_name("android");
        phone.setOs(os);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturer_id(38);
        manufacturer.setManufacturername("nokia");
        manufacturer.setCountry("india");
        phone.setManufacturer(manufacturer);

        return phone;

    }
}
