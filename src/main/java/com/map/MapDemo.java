package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Create Question
//		Question q1 = new Question();
//		q1.setQid(122);
//		q1.setQuestion("What is java");
//
//		// Creating Ans
//		Answer ans = new Answer();
//		ans.setAnsid(35);
//		ans.setAns("Java is programming languge");
//
//		// Creating Ans
//		Answer ans1 = new Answer();
//		ans1.setAnsid(36);
//		ans1.setAns("It is open source and Free");
//		
//		List<Answer> list=new ArrayList<Answer>();
//		list.add(ans);
//		list.add(ans1);
//		
//		q1.setAnswer(list);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

//		s.save(ans);
//		s.save(ans1);
//		s.save(q1);
		
		Question q=(Question)s.get(Question.class, 122);
		System.out.println(q.getQuestion());
		
		for(Answer a:q.getAnswer()) {
			System.out.println(a.getAns());
		}
		
		tx.commit();
		factory.close();

	}

}
