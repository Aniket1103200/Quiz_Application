package com.quiz.dto.request;

import org.hibernate.validator.constraints.Length;

import com.quiz.customAnotation.ValidOptions;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class QuestionDto {
	@NotBlank(message = "title required")
	@Length(max = 250,message = "maximum 250 characters allowed")
	private String title;
	@NotBlank(message = "title required")
	@Length(max = 250,message = "maximum 250 characters allowed")
	private String topic;
	@NotNull
	@ValidOptions(message ="All 4 options are required !" )
	private String[] options=new String[4];
	@NotBlank(message = "Answer Required")
	@Length(max = 100,message = "max 100 character you can enter")
	private String answer;
	@Length(max = 255,message = "Max 255 characters allowed")
	private String description; 
}
