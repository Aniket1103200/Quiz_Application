package com.quiz.dto.response;

import com.quiz.entity.Quiz;
import com.quiz.entity.User;
import com.quiz.entity.enums.Grade;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResultResponseDto {
	
	private Double score;
	
	private Double maxScore;
	
	private Grade result;
	
	private String quizTopic;
	
	private Long quizId;
	
	private int notAttemptedQuestions;
	
	private int wrongAnswers;
	
	private UserResponseDto user;
}
