package com.doubtsoverflow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doubtsoverflow.app.model.Answer;
import com.doubtsoverflow.app.service.AnswerService;

@RestController
@RequestMapping("/postAnswer")
public class AnswerHandler {
	@Autowired
	private AnswerService answerService;
	
	@PostMapping
	public ResponseEntity<Answer> saveAnswer (@RequestBody Answer answer) {
		return new ResponseEntity<Answer>(answerService.saveAnswer(answer) ,HttpStatus.CREATED);
	}

}
