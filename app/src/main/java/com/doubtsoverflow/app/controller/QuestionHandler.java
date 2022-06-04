package com.doubtsoverflow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doubtsoverflow.app.model.Question;
import com.doubtsoverflow.app.service.QuestionService;

@RestController
@RequestMapping("/postQuestion")
public class QuestionHandler {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping
	public ResponseEntity<Question> saveQuestion (@RequestBody Question question) {
		return new ResponseEntity<Question>(questionService.saveQuestion(question) ,HttpStatus.CREATED);
	}
}
