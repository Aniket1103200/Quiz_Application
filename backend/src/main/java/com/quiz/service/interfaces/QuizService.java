package com.quiz.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quiz.dto.response.QuizResponseDto;
import com.quiz.dto.response.UserResponseDto;
import com.quiz.util.ApiResponse;

public interface QuizService {

	public ResponseEntity<ApiResponse<QuizResponseDto>> createQuiz(String topic,int noOfQuestion);
	
	
	public ResponseEntity<ApiResponse<QuizResponseDto>> getQuizById(long id);
	
	public ResponseEntity<ApiResponse<List<QuizResponseDto>>> getListOfQuizByTopic(String topic);
	
}
