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

public class MainClassCreditCheque {


        public static void main(String[] args) {


            SessionFactory sessionFactory= SessionFactoryHolder.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            InheritChildCreditCard inheritChildCreditCard=new InheritChildCreditCard();

            inheritChildCreditCard.setPaymentId(10);
            inheritChildCreditCard.setAmount(2500);
            inheritChildCreditCard.setCreditCardType("Visa");

            InheritChildCheque inheritChildCheque=new InheritChildCheque();

            inheritChildCheque.setPaymentId(11);
            inheritChildCheque.setAmount(2600);
            inheritChildCheque.setChequeType("ICICI");

            session.save(inheritChildCreditCard);
            session.save(inheritChildCheque);
            transaction.commit();
            System.out.println("Parent child Object saved successfully.....!!");
            session.close();
            sessionFactory.close();

        }

}
