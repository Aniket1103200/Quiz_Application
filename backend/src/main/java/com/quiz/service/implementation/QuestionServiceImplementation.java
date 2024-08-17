package com.quiz.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.quiz.dao.QuestionDao;
import com.quiz.dto.request.QuestionDto;
import com.quiz.dto.response.QuestionResponseDto;
import com.quiz.entity.Question;
import com.quiz.exception.customException.ResourceNotFoundException;
import com.quiz.service.interfaces.QuestionService;
import com.quiz.util.ApiResponse;
import com.quiz.util.ResponseUtils;

public class QuestionServiceImplementation implements QuestionService {
	@Autowired
	private QuestionDao myQuestion;
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public ResponseEntity<ApiResponse<QuestionResponseDto>> addQuestion(QuestionDto newQuestion) {
		// TODO Auto-generated method stub
		Question question=mapper.map(newQuestion, Question.class);
		myQuestion.save(question);
		QuestionResponseDto questionResponse=mapper.map(question, QuestionResponseDto.class);
		ApiResponse<QuestionResponseDto> response=ResponseUtils.createSuccessResponse(questionResponse, "successfully added !!");
		
		return new ResponseEntity<ApiResponse<QuestionResponseDto>>(response,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ApiResponse<QuestionResponseDto>> getQuestionById(long id) {
		// TODO Auto-generated method stub
		Question question=myQuestion.findById(id).orElseThrow(()->new ResourceNotFoundException("No Any Question available with this id !!"));
		QuestionResponseDto questionResponse=mapper.map(question, QuestionResponseDto.class);
		ApiResponse<QuestionResponseDto> response=ResponseUtils.createSuccessResponse(questionResponse, "successfully fatched !!");
		return new ResponseEntity<ApiResponse<QuestionResponseDto>>(response,HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ApiResponse<List<QuestionResponseDto>>> getListOfQuestionByTopic(String topic,
			int noOfQuestions) {
		List<Question> questions=myQuestion.findRandomQuestionsByTopic(topic, noOfQuestions).orElseThrow(()->new ResourceNotFoundException("No any question present with this topic !!"));
		
		List<QuestionResponseDto> listQuestions=new ArrayList(questions.size());
		
	List<QuestionResponseDto> list= questions.stream().map(q->mapper.map(q, QuestionResponseDto.class)).collect(Collectors.toList());
		ApiResponse<List<QuestionResponseDto>> response=ResponseUtils.createSuccessResponse(list, "successfully fatch !!");
		return new ResponseEntity<ApiResponse<List<QuestionResponseDto>>>(response,HttpStatus.OK);
	}

}
