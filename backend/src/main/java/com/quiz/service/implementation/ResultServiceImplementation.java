package com.quiz.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.quiz.dao.QuizDao;
import com.quiz.dao.ResultDao;
import com.quiz.dao.UserDao;
import com.quiz.dto.request.AnswerRequestDto;
import com.quiz.dto.response.ResultResponseDto;
import com.quiz.dto.response.UserResponseDto;
import com.quiz.entity.Quiz;
import com.quiz.entity.Result;
import com.quiz.entity.User;
import com.quiz.entity.enums.Grade;
import com.quiz.exception.customException.ResourceNotFoundException;
import com.quiz.service.interfaces.ResultService;
import com.quiz.util.ApiResponse;
import com.quiz.util.ResponseUtils;

public class ResultServiceImplementation implements ResultService {
	@Autowired
	private ResultDao myResult;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private QuizDao myQuiz;
	@Autowired
	private UserDao myUser;
	@Override
	public ResponseEntity<ApiResponse<Result>> getResultById(long id) {
		// TODO Auto-generated method stub
		Result result=myResult.findById(id).orElseThrow(()->new ResourceNotFoundException("No any result availiable with this id !!"));
		ApiResponse<Result> response=ResponseUtils.createSuccessResponse(result, "Successfully fatched !!");
		return new ResponseEntity<ApiResponse<Result>>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponse<ResultResponseDto>> submitQuiz(AnswerRequestDto answer) {
		// TODO Auto-generated method stub
		Quiz quiz=myQuiz.findById(answer.getQuizId()).orElseThrow(()->new ResourceNotFoundException("No quiz find with the quiz id::"+answer.getQuizId())); 
		User user=myUser.findById(answer.getUserId()).orElseThrow(()->new ResourceNotFoundException("No User register with the id::"+answer.getUserId()));
		
		int wrongAnswer=0,noOfUnAttemptQuestions=0,score=0;
		ResultResponseDto result=new ResultResponseDto();
		result.setUser(mapper.map(user, UserResponseDto.class));
		result.setMaxScore(quiz.getMaxScore());
		result.setQuizId(quiz.getId());
		result.setQuizTopic(quiz.getTopic());
		for(int i=0;i<=answer.getAnswers().size();i++)
		{
			if(answer.getAnswers().get(i)==null) noOfUnAttemptQuestions++;
			else if(!answer.getAnswers().get(i).equals(quiz.getQuestion().get(i)))
			{
				wrongAnswer++;
			}
			else score++;
		}
		result.setNotAttemptedQuestions(noOfUnAttemptQuestions);
		result.setScore(score);
		result.setWrongAnswers(wrongAnswer);
		double percentage=score*100/quiz.getMaxScore();
		
		if(percentage>80)result.setResult(Grade.valueOf("A"));
		else if(percentage>70)result.setResult(Grade.valueOf("B"));
		else if(percentage>60)result.setResult(Grade.valueOf("C"));
		else if(percentage>50)result.setResult(Grade.valueOf("D"));
		else result.setResult(Grade.valueOf("FAIL"));
		ApiResponse<ResultResponseDto> response=ResponseUtils.createSuccessResponse(result, "Successfully Result created !!");
		return new ResponseEntity<ApiResponse<ResultResponseDto>>(response,HttpStatus.CREATED);
	
	}

	@Override
	public ResponseEntity<ApiResponse<List<Result>>> getListOfResultByUID(long userId) {
		// TODO Auto-generated method stub
		List<Result> results=myResult.findByUser(userId).orElseThrow(()->new ResourceNotFoundException("No any result availiable for the user id ::"+userId));
		ApiResponse<List<Result>> response=ResponseUtils.createSuccessResponse(results, "successfully fatched !");
		
		return new ResponseEntity<ApiResponse<List<Result>>>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponse<List<Result>>> getListOfResultByQuizId(long quizId) {
		// TODO Auto-generated method stub
		List<Result> results=myResult.findByQuiz(quizId).orElseThrow(()->new ResourceNotFoundException("No any result availiable for the quiz id ::"+quizId));
ApiResponse<List<Result>> response=ResponseUtils.createSuccessResponse(results, "successfully fatched !");
		
		return new ResponseEntity<ApiResponse<List<Result>>>(response,HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ApiResponse<List<UserResponseDto>>> getTop5StudentByQuizId(long quizId) {
		// TODO Auto-generated method stub
		
		List<Result> results=myResult.findTop5ByQuizOrderByScoreDesc(quizId).orElseThrow(()->new ResourceNotFoundException("No any result availiable for the quiz id ::"+quizId));
		List<UserResponseDto> users=new ArrayList<>(results.size());
		for(int i=0;i<=results.size();i++)
		{
			users.add(mapper.map(results.get(i).getUser(), UserResponseDto.class)); 
		}
		
		ApiResponse<List<UserResponseDto>> response=ResponseUtils.createSuccessResponse(users, "successfully fatched !");
		
		return new ResponseEntity<ApiResponse<List<UserResponseDto>>>(response,HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ApiResponse<List<UserResponseDto>>> getFailStudentByQuizId(long quizId) {
		// TODO Auto-generated method stub
		List<Result> results=myResult.findByQuiz(quizId).orElseThrow(()->new ResourceNotFoundException("No any result availiable for the quiz id ::"+quizId));
	List<UserResponseDto> users=results.stream().filter(r->r.getResult().equals("FAIL")).map(r->mapper.map(r.getUser(),UserResponseDto.class)).collect(Collectors.toList());
	ApiResponse<List<UserResponseDto>> response=ResponseUtils.createSuccessResponse(users, "successfully fatched !");
	
	return new ResponseEntity<ApiResponse<List<UserResponseDto>>>(response,HttpStatus.OK);
	}

}
