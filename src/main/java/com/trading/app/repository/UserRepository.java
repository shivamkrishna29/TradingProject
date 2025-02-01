package com.trading.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trading.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
}
