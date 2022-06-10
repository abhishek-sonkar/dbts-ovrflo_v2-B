package com.doubtsoverflow.app.service;

import java.util.List;

import com.doubtsoverflow.app.model.Answer;
import com.doubtsoverflow.app.model.Question;

public interface QuestionService {
	Question saveQuestion(Question question);
	
	List<Question> getAllQuestions();
	
	Question findQuestionById(int id);
	
	Question updateQuestion(Answer answer, int id);
}
