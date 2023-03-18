package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student std1 = new Student();

		std1.setId(1);
		std1.setName("Ankit Tiwari");
		std1.setCity("Mumbai");

		Student std2 = new Student();

		std2.setId(2);
		std2.setName("Ankit Tiwari");
		std2.setCity("Mumbai");

		Certificate certi1 = new Certificate();
		certi1.setCourse("Android");
		certi1.setDuration("6 Months");
		
		Certificate certi2 = new Certificate();
		certi2.setCourse("Java");
		certi2.setDuration("5 Months");

		std1.setCerti(certi1);
		std2.setCerti(certi2);
		
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		//Save Objects
		session.save(std1);
		session.save(std2);

		factory.close();

	}

}
