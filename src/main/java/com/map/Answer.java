package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	
	@Id
	@Column(name="ans_id")
	private int ansid;
	private String ans;
	
	
	@ManyToOne
	private Question question;
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int ansid, String ans, Question question) {
		super();
		this.ansid = ansid;
		this.ans = ans;
		this.question = question;
	}

	public int getAnsid() {
		return ansid;
	}

	public void setAnsid(int ansid) {
		this.ansid = ansid;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	

}
