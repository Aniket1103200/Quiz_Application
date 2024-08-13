package com.quiz.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quiz.dto.request.QuestionDto;
import com.quiz.dto.response.QuestionResponseDto;
import com.quiz.util.ApiResponse;

public interface QuestionService {

	public ResponseEntity<ApiResponse<QuestionResponseDto>> addQuestion(QuestionDto newQuestion);
	
	public ResponseEntity<ApiResponse<QuestionResponseDto>> getQuestionById(long id);
	
	public ResponseEntity<ApiResponse<List<QuestionResponseDto>>> getListOfQuestionByTopic(String topic,int noOfQuestions);
	
}
