package com.quiz.dto.request;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.quiz.entity.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class RegisterUserRequestDto {
	
	@NotBlank(message = "name required")
	@Length(min = 2,max = 250,message = "min 2 character required or maximum 250")
	private String name;
	@NotBlank(message = "email required")
	@Email(message = "valid email required")
	@NotNull(message = "email cant be null !")
	private String email;
	@NotBlank(message = "password required")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\r\n",message = "Minimum 8 character required in which atleast 1 uppercase, 1 lowercase, 1 digit, 1 special char should be present")
	@NotNull(message = "password cant be null!")
	private String password;
	
	private Role role;
	@NotNull(message = "Date of Birth Required")
	private LocalDate dob;
}
