package com.doubtsoverflow.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Answers")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quesId;
	private String ans;
	private int votes;
	private String answeredBy;
	private String answeredOnDate;
	
	
	
	public Answer(int id, int quesId, String ans, int votes, String answeredBy, String answeredOnDate) {
		super();
		this.id = id;
		this.setQuesId(quesId);
		this.ans = ans;
		this.votes = votes;
		this.answeredBy = answeredBy;
		this.answeredOnDate = answeredOnDate;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuesId() {
		return quesId;
	}
	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}
	
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	public String getAnsweredBy() {
		return answeredBy;
	}
	public void setAnsweredBy(String answeredBy) {
		this.answeredBy = answeredBy;
	}
	
	public String getAnsweredOnDate() {
		return answeredOnDate;
	}
	public void setAnsweredOnDate(String answeredOnDate) {
		this.answeredOnDate = answeredOnDate;
	}
	
	@Override
	public String toString() {
		return "Answer [id=" + id + ", ans=" + ans + ", votes=" + votes + ", answeredBy=" + answeredBy
				+ ", answeredOnDate=" + answeredOnDate + "]";
	}
}
