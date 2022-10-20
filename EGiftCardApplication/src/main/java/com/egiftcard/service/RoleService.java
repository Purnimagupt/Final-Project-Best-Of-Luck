package com.egiftcard.service;

import org.springframework.stereotype.Service;

import com.egiftcard.entity.Role;
import com.egiftcard.repository.RoleRepository;

@Service
public class RoleService {
	
	private RoleRepository roleRepo;
	
	public Role createNewRole(Role role) {
		return roleRepo.save(role);
	}
}
