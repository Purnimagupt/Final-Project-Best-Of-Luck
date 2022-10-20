package com.egiftcard.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.egiftcard.entity.Role;
import com.egiftcard.entity.User;
import com.egiftcard.repository.RoleRepository;
import com.egiftcard.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User registerUser(User user) {
		Role role=roleRepo.findById("User").get();
		Set<Role> roles=new HashSet<>();
		roles.add(role);
		user.setRole(roles);
		user.setPassword(getEncodedPassword(user.getPassword()));
		return userRepo.save(user);
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

	public void initRolesAndUser() {
		
		Role adminRole=new Role();
		adminRole.setRole("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleRepo.save(adminRole);
		
		Role userRole=new Role();
		userRole.setRole("User");
		userRole.setRoleDescription("User Role");
		roleRepo.save(userRole);
		
		User adminUser=new User();
		adminUser.setUserName("admin");
		adminUser.setName("admin");
		adminUser.setEmail("admin@egiftcard.com");
		adminUser.setMobile("1111111111");
		adminUser.setPassword(getEncodedPassword("admin"));
		Set<Role> adminRoles=new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userRepo.save(adminUser);
		
		
	}
}


