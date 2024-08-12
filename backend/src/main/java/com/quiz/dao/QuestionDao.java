package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.Question;

public interface QuestionDao extends JpaRepository<Question, Long> {

}
