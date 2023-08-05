package com.glearning.emps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.emps.model.Role;
import com.glearning.emps.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {

	@Autowired
	private RoleService roleService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Role saveRole(@RequestBody Role role) {
		return roleService.save(role);
	}
}
