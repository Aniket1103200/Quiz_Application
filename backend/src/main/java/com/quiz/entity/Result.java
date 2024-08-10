package com.quiz.entity;

import com.quiz.entity.enums.Grade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "results")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Result extends BaseEntity {
	
	@Column(nullable = false)
	private Double score;
	@Column(nullable = false)
	private Double maxScore;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Grade result;
	@ManyToOne
	private Quiz quiz;
	@ManyToOne
	private User user;
}
