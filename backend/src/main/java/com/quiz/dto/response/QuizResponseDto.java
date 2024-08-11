package com.quiz.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.quiz.entity.Question;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;

public class QuizResponseDto {
	private long id;
	
	private String topic;
	
	private List<Question> question;
	
	private int maxScore;
}
