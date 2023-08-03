package com.glearning.emps.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.emps.dao.RoleRepository;
import com.glearning.emps.model.Role;
import com.glearning.emps.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}
}
