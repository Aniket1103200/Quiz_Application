package com.quiz.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

	public Optional<User> findByEmail(String email);
	
	
	
}
