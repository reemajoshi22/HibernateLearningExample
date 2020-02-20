package main;

import inheritenceinhibernate.InheritChildCheque;
import inheritenceinhibernate.InheritChildCreditCard;
import oneToManyBiderectional.Customer;
import oneToManyBiderectional.Vendor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sessionFactory.SessionFactoryHolder;

import java.util.HashSet;
import java.util.Set;

public class MainClassOneToManyBirectional {

        public static void main(String[] args) {
            SessionFactory sessionFactory= SessionFactoryHolder.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Vendor v =new Vendor();

            v.setVendorId(101);
            v.setVendorName("java4s");

            Customer c1=new Customer();

            c1.setCustomerId(504);
            c1.setCustomerName("customer4");

            Customer c2=new Customer();

            c2.setCustomerId(505);
            c2.setCustomerName("customer5");

            Customer c3=new Customer();

            c3.setCustomerId(506);
            c3.setCustomerName("customer6");

            // one-to-many
            Set s=new HashSet();

            s.add(c1);
            s.add(c2);
            s.add(c3);

            v.setChildren(s);

            // many-to-one

            c1.setParentObjets(v);
            c2.setParentObjets(v);
            c3.setParentObjets(v);

            session.save(c1);
            //session.save(v);

            transaction.commit();
            System.out.println("Parent child Object saved successfully.....!!");
            session.close();
            sessionFactory.close();

        }

}
