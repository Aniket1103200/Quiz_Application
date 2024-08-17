package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.dto.request.QuestionDto;

import com.quiz.dto.response.QuestionResponseDto;
import com.quiz.dto.response.QuizResponseDto;
import com.quiz.service.interfaces.QuizService;
import com.quiz.util.ApiResponse;

import jakarta.validation.Valid;

public class QuizController {
	@Autowired
	private QuizService myQuiz;
	
	
	@PostMapping  //http://localhost:8080/question    method : POST
	public ResponseEntity<ApiResponse<QuizResponseDto>> createQuiz(@RequestParam String topic,@RequestParam int noOfQuestion)
	{
		return myQuiz.createQuiz(topic,noOfQuestion);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<QuizResponseDto>> getQuiz(@PathVariable long id)
	{
		return myQuiz.getQuizById(id);
	}
	
	@GetMapping("/list_of_quiz")
	public ResponseEntity<ApiResponse<List<QuizResponseDto>>> getListOfQuiz(@RequestParam String topic)
	{
		return myQuiz.getListOfQuizByTopic(topic);
	}
}
