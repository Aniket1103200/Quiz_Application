package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
