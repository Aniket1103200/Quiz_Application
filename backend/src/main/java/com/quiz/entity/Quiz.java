package com.quiz.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "quizes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"question","result"})
public class Quiz extends BaseEntity {
	@Column(nullable = false,length = 150)
	private String topic;
	@ManyToMany
	private List<Question> question=new ArrayList<>();
	@Column(nullable = false)
	private int maxScore;
	@OneToMany(mappedBy = "quiz")
	private List<Result> result = new ArrayList<>();
	
	public void addQuestion(Question question){ //bi-directional method to set forgien key.
		this.getQuestion().add(question);
		question.getQuiz().add(this);
	}
	
	public void addResult(Result result) {
		this.getResult().add(result);
		result.setQuiz(this);
	}
}
