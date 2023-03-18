package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FetchDemp {

	public static void main(String[] args) {
		
		//get and load
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		//GEt 
		Student student=(Student)session.get(Student.class, 101);
		System.out.println(student);
		
		Address address=(Address)session.get(Address.class,2);
		System.out.println(address.getStreet());
		
		
		
		factory.close();

	}

}
