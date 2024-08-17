package com.quiz.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.entity.Question;

public interface QuestionDao extends JpaRepository<Question, Long> {

	@Query(value = "SELECT * FROM question WHERE topic = :topic ORDER BY RAND() LIMIT :noOfQuestion", nativeQuery = true)
    Optional<List<Question>> findRandomQuestionsByTopic(
            @Param("topic") String topic,
            @Param("noOfQuestion") int noOfQuestion);

}
