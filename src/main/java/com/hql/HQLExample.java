package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {
	
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		
//		Student1 s1=new Student1();
//		s1.setId(12);
//		s1.setName("Santosh");
//		s1.setCity("Islamkot");
//		
//		Student1 s2=new Student1();
//		s2.setId(11);
//		s2.setName("Kumar");
//		s2.setCity("Mithi");
//		
//		ss.save(s1);
//		ss.save(s2);
//		
//		tx.commit();
		
		
		//HQL
		String query="from Student1 as s where s.name=:x and s.id=11";
		Query q=ss.createQuery(query);
		q.setParameter("x", "kumar");
		
		//Single(uniue)
		// multiple result
		List<Student1> list=q.list();
		
		for(Student1 s:list) 
		{
			System.out.println(s.getName()+" "+s.getId()+" "+s.getCity());
		}
		
		
		System.out.println("_______________________________");
		
		
		//Update Query
		
		/*
		 * Query q2=ss.createQuery("delete from Student1 as s where s.city=:x");
		 * q2.setParameter("x", "Mithi"); int r=q2.executeUpdate();
		 * 
		 * System.out.println("Deleted::::"); System.out.println(r);
		 */
		
//		//Delete Query
//		Query q2=ss.createQuery("update Student1 set city=:c where name=:n");
//	    q2.setParameter("c", "UKt");
//	    q2.setParameter("n", "Santosh");
//	    int r=q2.executeUpdate();
//	    
//	    System.out.println(r+" objects updated...");
		
		Query q3=ss.createQuery("select q.question, q.qid, a.answer from Question as q INNER JOIN q.answer as a");
		List<Object []> list1=q3.getResultList();
		
		for(Object[] arr:list1) {
			System.out.println(Arrays.toString(arr));
		}
		
		ss.close();
		sf.close();
	}

}
