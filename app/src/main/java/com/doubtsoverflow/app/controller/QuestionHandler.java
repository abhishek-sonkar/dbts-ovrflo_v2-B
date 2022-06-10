package com.doubtsoverflow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doubtsoverflow.app.model.Question;
import com.doubtsoverflow.app.service.QuestionService;

@RestController
public class QuestionHandler {

	@Autowired
	private QuestionService questionService;
	
	
	// Create questions
	@PostMapping("/postQuestion")
	public ResponseEntity<Question> saveQuestion (@RequestBody Question question) {
		return new ResponseEntity<Question>(questionService.saveQuestion(question) ,HttpStatus.CREATED);
	}
	
	//get all questions
	@GetMapping("/allQuestions")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions(); 
	}
	
	//find question by id
	@GetMapping("/getById/{id}")
	public ResponseEntity<Question> getQuestionByID(@PathVariable("id") int quesId) {
		return new ResponseEntity<Question>(questionService.findQuestionById(quesId), HttpStatus.OK);
	}
}
