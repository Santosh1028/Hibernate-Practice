package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.Student1;
import com.tut.Student;


public class SecondLevelCache {
	
	public static void main(String[] args) {
		Configuration cfx=new Configuration();
		SessionFactory sf=cfx.configure("hibernate.cfg.xml").buildSessionFactory();
		
		//First
		Session ss1=sf.openSession();
		
		Student s1 = ss1.get(Student.class, 12);
		ss1.close();
		
		//Second
		Session ss2=sf.openSession();
		
		Student s2 = ss2.get(Student.class, 12);
		ss1.close();
	}

}
