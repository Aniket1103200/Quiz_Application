package com.quiz.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Long> {

	public Optional<List<Quiz>> findByTopic(String topic);
}
