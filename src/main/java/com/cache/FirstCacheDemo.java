package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.Student1;

public class FirstCacheDemo {
	
	public static void main(String[] args) {
		Configuration cfx=new Configuration();
		SessionFactory sf=cfx.configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session ss=sf.openSession();
		
		Student1 s1 = ss.get(Student1.class, 1);
		
		System.out.println(s1.getName());
		
		System.out.println("Working Something......");
		
		Student1 s2 = ss.get(Student1.class, 2);
		System.out.println(s2.getId());
		
		
		System.out.println(ss.contains(s1));
		ss.close();
		sf.close();
	}

}
