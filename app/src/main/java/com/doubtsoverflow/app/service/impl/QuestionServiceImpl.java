package com.doubtsoverflow.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doubtsoverflow.app.exception.ResourceNotFoundException;
import com.doubtsoverflow.app.model.Answer;
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

	@Override
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public Question findQuestionById(int id) {
		return questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question", "id", id));
	}

	@Override
	public Question updateQuestion(Answer answer, int id) {
		
		Question existingQuestion = questionRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Question", "id", id));
		
		existingQuestion.getAnswers().add(answer);
		questionRepository.save(existingQuestion);
		return existingQuestion;
	}
}

	
