package com.doubtsoverflow.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doubtsoverflow.app.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

}
