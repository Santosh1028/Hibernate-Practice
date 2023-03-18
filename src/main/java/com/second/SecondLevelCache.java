package com.second;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.Student1;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.hibernate.EhCacheRegionFactory;

public class SecondLevelCache {
	
	public static void main(String[] args) {
		
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session ss1=sf.openSession();
		Student1 s1 = ss1.get(Student1.class, 1);
		System.out.println(s1);
		
		ss1.close();
		
		Session ss2=sf.openSession();
		Student1 s2 = ss2.get(Student1.class, 2);
		System.out.println(s2);
		ss2.close();
		
	}

}
