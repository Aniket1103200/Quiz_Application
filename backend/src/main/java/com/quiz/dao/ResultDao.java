package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.Result;

public interface ResultDao extends JpaRepository<Result, Long> {

}
