package com.quiz.dto.response;

import java.time.LocalDate;

import com.quiz.entity.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserResponseDto {
	private long id;
	
	private String name;
	
	private String email;
	
	private Role role;//Role as in Student or Teacher
	
	private LocalDate dob;
}
