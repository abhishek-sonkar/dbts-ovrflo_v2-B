package com.doubtsoverflow.app.service.impl;

import org.springframework.stereotype.Service;

import com.doubtsoverflow.app.model.Question;
import com.doubtsoverflow.app.repository.QuestionRepository;
import com.doubtsoverflow.app.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	private QuestionRepository questionRepository;

	public QuestionServiceImpl(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}

	@Override
	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}
}
