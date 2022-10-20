package com.egiftcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard.entity.Role;
import com.egiftcard.service.RoleService;

@RestController
@CrossOrigin
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	
	@PostMapping("/createNewRole")
	public Role createNewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
	}
	
}
