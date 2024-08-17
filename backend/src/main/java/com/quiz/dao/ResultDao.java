package com.quiz.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quiz.entity.Result;

public interface ResultDao extends JpaRepository<Result, Long> {

	public Optional<List<Result>> findByUser(long uid);
	
	public Optional<List<Result>> findByQuiz(long qid);
	
	Optional<List<Result>> findTop5ByQuizOrderByScoreDesc(long qId);

}
