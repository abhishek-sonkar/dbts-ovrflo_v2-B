package com.doubtsoverflow.app.service.impl;

import org.springframework.stereotype.Service;

import com.doubtsoverflow.app.model.Answer;
import com.doubtsoverflow.app.repository.AnswerRepository;
import com.doubtsoverflow.app.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService{

	AnswerRepository answerRepository;
	
	public AnswerServiceImpl(AnswerRepository answerRepository) {
		super();
		this.answerRepository = answerRepository;
	}

	@Override
	public Answer saveAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
}
