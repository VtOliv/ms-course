package com.mstraining.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mstraining.hroauth.entities.User;
import com.mstraining.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient feignClient;
	
	
	public User findByEmail(String email) {
		User user = feignClient.findByEmail(email).getBody();
		if(user == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found: "+ email);
		return user;
	}

}
