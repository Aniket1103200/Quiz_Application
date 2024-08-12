package com.quiz.dto.response;

import org.hibernate.validator.constraints.Length;

import com.quiz.customAnotation.ValidOptions;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class QuestionResponseDto {
	private Long id;
	private String title;
	private String topic;
	private String[] options=new String[4];
	private String answer;
	private String description; 

}
