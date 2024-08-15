package com.quiz.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quiz.dao.UserDao;
import com.quiz.dto.request.LoginRequestDto;
import com.quiz.dto.request.RegisterUserRequestDto;
import com.quiz.dto.response.UserResponseDto;
import com.quiz.entity.User;
import com.quiz.exception.customException.QuizApplicationException;
import com.quiz.exception.customException.ResourceNotFoundException;
import com.quiz.service.interfaces.UserService;
import com.quiz.util.ApiResponse;
import com.quiz.util.ResponseUtils;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class userServiceImplementation implements UserService {
	
	@Autowired
	private UserDao myDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder myEncoder;
	
	@Override
	public ResponseEntity<ApiResponse<UserResponseDto>> registerUser  (RegisterUserRequestDto newUser) {
		// TODO Auto-generated method stub
		User myNewUser= mapper.map(newUser, User.class); 
		 
	User user=myDao.save(myNewUser);
	UserResponseDto responseDto=mapper.map(user, UserResponseDto.class);
	
	ApiResponse<UserResponseDto> response=ResponseUtils.createSuccessResponse(responseDto, "Successfully register !!");
		
		return new ResponseEntity<ApiResponse<UserResponseDto>>(response,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ApiResponse<UserResponseDto>> LoginUser(LoginRequestDto data) {
		// TODO Auto-generated method stub
	User user=	myDao.findByEmail(data.getEmail()).orElseThrow(()->new ResourceNotFoundException("Email not registered !!"));
	if(!myEncoder.matches(data.getPassword(), user.getPassword()))
	{
		throw new QuizApplicationException("wrong password !!");
	}
	
	UserResponseDto userDto = mapper.map(user, UserResponseDto.class);
	ApiResponse<UserResponseDto> response=ResponseUtils.createSuccessResponse(userDto, "Successfully Authenticate !!");
	
	return new ResponseEntity<ApiResponse<UserResponseDto>>(response,HttpStatus.ACCEPTED);
	
	}

	@Override
	public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(RegisterUserRequestDto user, long id) {
		// TODO Auto-generated method stub
		User myUser=	myDao.findById(id).orElseThrow(()->new ResourceNotFoundException("InValid ID !!"));
		User modifyUser=mapper.map(user,User.class);
		modifyUser.setId(id);
		myDao.save(modifyUser);
		UserResponseDto userDto=mapper.map(modifyUser, UserResponseDto.class);
		ApiResponse<UserResponseDto> response=ResponseUtils.createSuccessResponse(userDto, "Successfully updated !!");
		return new ResponseEntity<ApiResponse<UserResponseDto>>(response,HttpStatus.ACCEPTED);
	}

}
