package com.quiz.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quiz.dto.request.AnswerRequestDto;
import com.quiz.dto.response.ResultResponseDto;
import com.quiz.dto.response.UserResponseDto;
import com.quiz.entity.Result;
import com.quiz.util.ApiResponse;

public interface ResultService {

	public ResponseEntity<ApiResponse<Result>> getResultById(long id);
	
	public ResponseEntity<ApiResponse<ResultResponseDto>> submitQuiz(AnswerRequestDto answer);
	
	public ResponseEntity<ApiResponse<List<Result>>> getListOfResultByUID(long userId);
	
	public ResponseEntity<ApiResponse<List<Result>>> getListOfResultByQuizId(long quizId);
	
	public ResponseEntity<ApiResponse<List<UserResponseDto>>> getTop5StudentByQuizId(long quizId);
	
	public ResponseEntity<ApiResponse<List<UserResponseDto>>> getFailStudentByQuizId(long quizId);
	
	
	
	
	
}
