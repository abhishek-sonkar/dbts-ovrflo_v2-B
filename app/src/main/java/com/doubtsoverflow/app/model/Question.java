package com.doubtsoverflow.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String tags;
	private String postedBy;
	private String postedOnDate;
	
	public Question(String title, String tags, String postedBy, String postedOnDate) {
		super();
		this.title = title;
		this.tags = tags;
		this.postedBy = postedBy;
		this.postedOnDate = postedOnDate;
	}
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String getpostedBy() {
		return postedBy;
	}
	public void setpostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	
	public String getpostedOnDate() {
		return postedOnDate;
	}
	public void setpostedOnDate(String postedOnDate) {
		this.postedOnDate = postedOnDate;
	}
	
	@Override
	public String toString() {
		return "Question [title=" + title + ", tags=" + tags + ", postedBy=" + postedBy
				+ ", postedOnDate=" + postedOnDate + "]";
	}
	

}
