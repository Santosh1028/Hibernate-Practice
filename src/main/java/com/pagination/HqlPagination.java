package com.pagination;

import org.hibernate.query.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.Student1;

public class HqlPagination {
	
	public static void main(String[] args) {
		
		Configuration cfx=new Configuration();
		SessionFactory sf=cfx.configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session ss=sf.openSession();
		
		Query<Student1> query=ss.createQuery("from Student1");
		
		//Implementing Pagination using hibernate
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		List<Student1> list=query.list();
		
		for(Student1 st:list) {
			System.out.println(st.getId()+" "+st.getName()+" "+st.getCity());
		}
		
		
		
		ss.close();
		sf.close();
	}

}
