package com.quiz.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import com.quiz.dao.QuestionDao;
import com.quiz.dao.QuizDao;
import com.quiz.dto.response.QuizResponseDto;
import com.quiz.entity.Question;
import com.quiz.entity.Quiz;
import com.quiz.exception.customException.ResourceNotFoundException;
import com.quiz.service.interfaces.QuizService;
import com.quiz.util.ApiResponse;
import com.quiz.util.ResponseUtils;

public class QuizServiceImplementation implements QuizService {
	
	@Autowired
	private QuizDao myQuiz;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private QuestionDao myQuestion;
	
	@Override
	public ResponseEntity<ApiResponse<QuizResponseDto>> createQuiz(String topic, int noOfQuestion) {
		// TODO Auto-generated method stub
	
		List<Question> questions=myQuestion.findRandomQuestionsByTopic(topic, noOfQuestion).orElseThrow(()->new ResourceNotFoundException("No any question present with this topic !!"));
		Quiz newQuiz=new Quiz();
		newQuiz.setTopic(topic);
		newQuiz.setMaxScore(questions.size());
		for(int i=0;i<questions.size();i++)
		{
			newQuiz.addQuestion(questions.get(i));
		}
		newQuiz=myQuiz.save(newQuiz);
		
		QuizResponseDto quizResponse=mapper.map(newQuiz, QuizResponseDto.class);
		ApiResponse<QuizResponseDto> response=ResponseUtils.createSuccessResponse(quizResponse, "quiz created !!");
		
		return new ResponseEntity<ApiResponse<QuizResponseDto>>(response,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ApiResponse<QuizResponseDto>> getQuizById(long id) {
		// TODO Auto-generated method stub
		Quiz quiz=myQuiz.findById(id).orElseThrow(()->new ResourceNotFoundException("No any Quiz registered with this id !!"));
		QuizResponseDto quizResponse=mapper.map(quiz, QuizResponseDto.class);
		ApiResponse<QuizResponseDto> response=ResponseUtils.createSuccessResponse(quizResponse, "quiz created !!");
		
		return new ResponseEntity<ApiResponse<QuizResponseDto>>(response,HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ApiResponse<List<QuizResponseDto>>> getListOfQuizByTopic(String topic) {
		// TODO Auto-generated method stub
		List<Quiz> list=myQuiz.findByTopic(topic).orElseThrow(()->new ResourceNotFoundException("No any quiz found with this topic !!"));
		List<QuizResponseDto> quizResponse=new ArrayList<>(list.size());
		for(int i=0;i<list.size();i++)
			quizResponse.add(mapper.map(list.get(i), QuizResponseDto.class));
		ApiResponse<List<QuizResponseDto>> response=ResponseUtils.createSuccessResponse(quizResponse, "successfully fetched !!");
		return new ResponseEntity<ApiResponse<List<QuizResponseDto>>>(response,HttpStatus.OK);
	}

}
