package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.dto.request.AnswerRequestDto;
import com.quiz.dto.response.QuizResponseDto;
import com.quiz.dto.response.ResultResponseDto;
import com.quiz.dto.response.UserResponseDto;
import com.quiz.entity.Result;
import com.quiz.service.interfaces.QuizService;
import com.quiz.service.interfaces.ResultService;
import com.quiz.util.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/result")
public class ResultController {
	@Autowired
	private ResultService myResult;
	
	
	
	@PostMapping  //http://localhost:8080/question    method : POST
	public ResponseEntity<ApiResponse<ResultResponseDto>> createResult(@RequestBody @Valid AnswerRequestDto answers)
	{
		return myResult.submitQuiz(answers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Result>> getResult(@PathVariable long id)
	{
		return myResult.getResultById(id);
	}
	
	@GetMapping("/list_of_result/user/{uId}")
	public ResponseEntity<ApiResponse<List<Result>>> getListOfResultByUserId(@PathVariable long uId)
	{
		return myResult.getListOfResultByUID(uId);
	}

	@GetMapping("/list_of_result/quiz/{qId}")
	public ResponseEntity<ApiResponse<List<Result>>> getListOfResultByQuizId(@PathVariable long qId)
	{
		return myResult.getListOfResultByQuizId(qId);
	}
	
	@GetMapping("/list_of_result/user/top5/{qId}")
	public ResponseEntity<ApiResponse<List<UserResponseDto>>> getListOfResultOfTop5(@PathVariable long qId)
	{
		return myResult.getTop5StudentByQuizId(qId);
	}
	
	@GetMapping("/list_of_result/user/fail/{qId}")
	public ResponseEntity<ApiResponse<List<UserResponseDto>>> getListOfResultOfFail(@PathVariable long qId)
	{
		return myResult.getFailStudentByQuizId(qId);
	}
	
}
