package com.mstraining.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstraining.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	User findByEmail(String email);
}
