package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {
	
	public static void main(String[] args) {
		
		Configuration cfx=new Configuration();
		SessionFactory sf=cfx.configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session ss=sf.openSession();
		
		Question q1 = new Question();
		q1.setQid(5);
		q1.setQuestion("What is cascading?");
		
		
//		Answer answer1 = new Answer(23, "In hibernate it is important concept");
//		Answer answer2 = new Answer(23, "In hibernate it is important concept");
//		Answer answer3 = new Answer(23, "In hibernate it is important concept");
//		
//		List<Answer> list=new ArrayList<Answer>();
//		list.add(answer1);
//		list.add(answer2);
//		list.add(answer3);
//		
//		
//		q1.setAnswer(list);
		
		sf.close();
		ss.close();
	}

}
