package com.glearning.emps.service;

import com.glearning.emps.model.Role;

public interface RoleService {
	Role save(Role role);

	Role findByName(String name);
}
