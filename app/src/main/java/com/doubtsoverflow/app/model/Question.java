package com.doubtsoverflow.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qid;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "question_body", nullable = false)
	private String quesBody;
	
	@Column(name = "user_posted", nullable = false)
	private String postedBy;
	
	@Column(name = "posted_date", nullable = false)
	private String postedOnDate;
	
	@OneToMany(targetEntity = Answer.class, cascade = javax.persistence.CascadeType.ALL)
	@JoinColumn(name = "ans_fk", referencedColumnName = "qid")
	private List<Answer> answers;
}
