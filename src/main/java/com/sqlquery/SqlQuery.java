package com.sqlquery;

import org.hibernate.query.*;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SqlQuery {
	
	public static void main(String[] args) {
		
		Configuration cfx=new Configuration();
		SessionFactory sf=cfx.configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session ss=sf.openSession();
		
		String q="select * from student1";
		
		NativeQuery nq = ss.createSQLQuery(q);
		List<Object[]> list = nq.list();
		
		for(Object[] s:list) {
			System.out.println(Arrays.deepToString(s));
		}
		
		ss.close();
		sf.close();
	}

}
