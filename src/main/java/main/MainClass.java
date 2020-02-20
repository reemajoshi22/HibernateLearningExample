package main;

import dao.Manufacturer;
import dao.OS;
import dao.Phone;
import inheritenceinhibernate.InheritChildCheque;
import inheritenceinhibernate.InheritChildCreditCard;
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

        /**
         * save()
         * persist()
         * saveOrUpdate()
         */
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

      /*  Object o = session.load(Phone.class, new Integer(2));
        Phone p=(Phone)o;
        System.out.println(p.getManufacturer());*/  // object not found excepeption as it doesnot exists
       /* Object getObject = session.get(Phone.class, new Integer(2));
        Phone getObject1 = (Phone) getObject;
        System.out.println(getObject1.getManufacturer());*/  // null pointer exception is thrown here as key 2 doesnot exists
        //p.setPhone_model("nokia"); //-- update first approach
        // hibernate stores the loaded object in the cache memory so when we modify the loaded
        // object the automatically it calls update after transaction is commited.
        // i.e hibernate maintains synchronization between cache memory and table objects.
//        System.out.println("loading the data from database of phone model and phone id : "+p.getPhone_model() +" "+p.getPhone_id());

        /**
         * delete the data
         *
         * we have only one method to delete an object from the database
         */

        Transaction deleteTransaction=session.beginTransaction();
       // session.delete(p);
        //System.out.println("Delete the data from database using delete method and the id of deleted phone is :"+p.getPhone_id());
        deleteTransaction.commit();

        session.close();
        sessionFactory.close();


        // updating data- we have two approaches in the hibernate for updating the data.

        //first approach : Load that object from the database, and modify its values,
        // now hibernate automatically modifies the
        // values on to database also, when ever the transaction is committed.

        // second approach :
        //If we want to modify object in the database,
        //then create new object with same id and we must call update()

       /* Transaction transaction3 = session.beginTransaction();
          Phone updateData1 = mainClass.prepareUpdateData();
          session.update(updateData1);
          transaction3.commit();
*/


        /**
         * If we want to know how many no of times that
         * an object is modified then we need to apply this versioning concept.
         *
         * When ever we use versioning then hibernate inserts version number as zero,
         * when ever object is saved for the first time in the database.
         * Later hibernate increments that version no by
         * one automatically when ever a modification is done on that particular object.
         */



    }

    private Phone prepareUpdateData() {
        Phone phone = new Phone();
        phone.setPhone_id(145);
        phone.setSim_slots("2");
        phone.setPhone_model("iphone");

        OS os = new OS();
        os.setOs_id(8);
        os.setOs_name("mac");
        phone.setOs(os);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturer_id(8);
        manufacturer.setManufacturername("apple");
        manufacturer.setCountry("usa");
        phone.setManufacturer(manufacturer);

        return phone;

    }


    private Phone preparePhoneInsertData() {

        /**i am using primitive data types.
         * i have not written setter for price
         *
         *
         * But once you execute this program in the database it will saves the price as 0(zero),
         * so misunderstanding of data will happen like phone price is zero
         */

        // if using wrapper classes then it will insert null
        Phone phone = new Phone();
        phone.setPhone_id(125);

        phone.setSim_slots("2");
        phone.setPhone_model("nokia11");

        OS os = new OS();
        os.setOs_id(208);
        os.setOs_name("android");
        phone.setOs(os);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturer_id(208);
        manufacturer.setManufacturername("nokia");
        manufacturer.setCountry("india");
        phone.setManufacturer(manufacturer);

        return phone;

    }
}
