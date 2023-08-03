package com.glearning.emps.service;

import com.glearning.emps.model.User;

public interface UserService {
	User save(User user);

	User findByUsername(String username);
}
