package com.quiz.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.quiz.entity.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "result")
public class User extends BaseEntity {
	@Column(nullable = false,length = 150)
	private String name;
	@Column(nullable = false,length = 150)
	private String email;
	@Column(nullable = false,length = 150)
	private String password;
	@Column(nullable = false,length = 150)
	@Enumerated(EnumType.STRING)
	private Role role;
	@Column(nullable = false)
	private LocalDate Dob;
	@OneToMany(mappedBy = "user")
	private List<Result> result = new ArrayList<>();
	
	public void addResult(Result result) {
		this.getResult().add(result);	
		result.setUser(this);
	}
}
