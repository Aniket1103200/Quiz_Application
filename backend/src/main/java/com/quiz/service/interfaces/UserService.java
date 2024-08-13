package com.quiz.service.interfaces;

import org.springframework.http.ResponseEntity;

import com.quiz.dto.request.LoginRequestDto;
import com.quiz.dto.request.RegisterUserRequestDto;
import com.quiz.dto.response.UserResponseDto;
import com.quiz.util.ApiResponse;

public interface UserService {
	
	
	public ResponseEntity<ApiResponse<UserResponseDto>> registerUser(RegisterUserRequestDto newUser);
	
	public ResponseEntity<ApiResponse<UserResponseDto>> LoginUser(LoginRequestDto data);
	
	public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(RegisterUserRequestDto newUser,long id);

	
	
	
	
	
	
	
}
