package com.quiz.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"quiz"})
public class Question extends BaseEntity {

	@Column(nullable = false,length = 255)
	private String title;
	@Column(nullable = false,length = 150)
	private String topic;
	@Column(nullable = false)
	private String[] options=new String[4];
	@Column(nullable = false,length = 100)
	private String answer;
	@Column(nullable = true,length = 255)
	private String description;
	@ManyToMany
	@JoinTable(name = "quiz_questions",
	joinColumns = @JoinColumn(name="quiz_id",referencedColumnName = "ID"),
	inverseJoinColumns = @JoinColumn(name="question_id",referencedColumnName = "ID"))
	private List<Quiz> quiz = new ArrayList<>();
}
