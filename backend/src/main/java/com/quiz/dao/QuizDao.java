package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Long> {

}
