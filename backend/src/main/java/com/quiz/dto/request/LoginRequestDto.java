package com.quiz.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class LoginRequestDto {
	@NotBlank(message = "email required")
	@Email(message = "valid email required")
	@NotNull(message = "email cant be null !")
	private String email;
	@NotBlank(message = "name required")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\r\n",message = "Minimum 8 character required in which atleast 1 uppercase, 1 lowercase, 1 digit, 1 special char should be present")
	@NotNull(message = "password cant be null !")
	private String password;
}
