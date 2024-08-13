package com.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.dto.request.LoginRequestDto;
import com.quiz.dto.request.RegisterUserRequestDto;
import com.quiz.dto.response.UserResponseDto;
import com.quiz.service.interfaces.UserService;
import com.quiz.util.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService myService;
	
	@PostMapping //http:localhost::8080/user     method :post
	public ResponseEntity<ApiResponse<UserResponseDto>> registerUser(@RequestBody @Valid RegisterUserRequestDto newUser)
	{
		return myService.registerUser(newUser);
	}
	
	@PutMapping("/{id}")//http:localhost::8080/user/1
	public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(@RequestBody @Valid RegisterUserRequestDto user,@PathVariable(name = "id") long id)
	{
		return myService.updateUser(user,id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<UserResponseDto>> loginUser(@RequestBody @Valid LoginRequestDto data)
	{
		return myService.LoginUser(data);
	}
	
	

}
