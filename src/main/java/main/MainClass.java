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
        session.save(phone);
        System.out.println("---data inserted---");

        transaction.commit();

        // delete data

         /* Transaction transaction2 = session.beginTransaction(); Phone
          prepareUpdateData = mainClass.prepareUpdateData();
          session.delete(prepareUpdateData);
          transaction2.commit();*/


        // updating data

          Transaction transaction3 = session.beginTransaction();
          Phone updateData1 = mainClass.prepareUpdateData();
          session.update(updateData1);
          transaction3.commit();



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
