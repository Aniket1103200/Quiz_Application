package com.quiz.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.quiz.dao.UserDao;
import com.quiz.dto.request.LoginRequestDto;
import com.quiz.dto.request.RegisterUserRequestDto;
import com.quiz.dto.response.UserResponseDto;
import com.quiz.service.interfaces.UserService;
import com.quiz.util.ApiResponse;

public class userServiceImplementation implements UserService {
	
	@Autowired
	private UserDao myDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder myEncoder;
	
	@Override
	public ResponseEntity<ApiResponse<UserResponseDto>> registerUser(RegisterUserRequestDto newUser) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public ResponseEntity<ApiResponse<UserResponseDto>> LoginUser(LoginRequestDto data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(RegisterUserRequestDto newUser, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
