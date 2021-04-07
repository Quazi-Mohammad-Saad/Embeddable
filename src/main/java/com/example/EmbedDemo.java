package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Student student1= new Student();
        student1.setId(101);
        student1.setName("Gyancho");
        student1.setCity("Babaganj");

        Certificate certificate = new Certificate();
        certificate.setCourse("Springboot");
        certificate.setDuration("1 Month");
        student1.setCerti(certificate);

        //Creating second instance

        Student student2= new Student();
        student2.setId(102);
        student2.setName("Bhola");
        student2.setCity("Nindura");

        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Spring");
        certificate1.setDuration("3 Month");

        student2.setCerti(certificate1);

        Session s = factory.openSession();
        Transaction tx= s.beginTransaction(); //As we want to store the data permanently

        //object save
        s.save(student1);
        s.save(student2);

        tx.commit();
        factory.close();
    }
}
