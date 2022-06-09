package com.doubtsoverflow.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "answers")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	
	@Column(name = "answer", nullable = false)
	private String ans;
	
	@Column(name = "votes")
	private int votes;
	
	@Column(name = "user_answered", nullable = false)
	private String answeredBy;
	
	@Column(name = "answered_date", nullable = false)
	private String answeredOnDate;
	
}
