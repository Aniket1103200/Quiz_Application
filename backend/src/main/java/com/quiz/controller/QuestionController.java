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

import com.quiz.dto.request.QuestionDto;
import com.quiz.dto.response.QuestionResponseDto;
import com.quiz.service.interfaces.QuestionService;
import com.quiz.util.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService myQuestion;
	
	@PostMapping  //http://localhost:8080/question    method : POST
	public ResponseEntity<ApiResponse<QuestionResponseDto>> addQuestion(@RequestBody @Valid QuestionDto newQuestion)
	{
		return myQuestion.addQuestion(newQuestion);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<QuestionResponseDto>> getQuestion(@PathVariable long id)
	{
		return myQuestion.getQuestionById(id);
	}
	
	@GetMapping("/fetch_set_of_questions") //http://localhost:8080/question/fetch_set_of_questions?topic="...."&noOfQuestions="..."
	public ResponseEntity<ApiResponse<List<QuestionResponseDto>>> getSetOfQuestions(@RequestParam String topic,@RequestParam int noOfQuestions)
	{
		return myQuestion.getListOfQuestionByTopic(topic, noOfQuestions);
	}
	
	
}
