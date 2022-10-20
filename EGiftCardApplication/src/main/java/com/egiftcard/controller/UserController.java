package com.egiftcard.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard.entity.User;
import com.egiftcard.exception.NoDataException;
import com.egiftcard.exception.NoSuchUserException;
import com.egiftcard.service.IUserManagementService;
import com.egiftcard.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/userservice")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private IUserManagementService service;
	
	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRolesAndUser();
	}
	
	//http://localhost:8080/EgiftCardApp/userservice/registerUser
	@PostMapping({"/registerUser"})
	public User registerUser(@RequestBody User user) {
			return userService.registerUser(user);
		}

	
	@GetMapping({"/forAdmin"})
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "for admin only";
	}
	
	@GetMapping({"/forUser"})
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "for user only";
	}
	
	//http://localhost:8080/EgiftCardApp/userservice/allUser
	@GetMapping("/allUser")
	public ResponseEntity<List<User>> getAllUsers() throws NoDataException {
		List<User> user = service.getAllUsers();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	//http://localhost:8080/EgiftCardApp/userservice/updateUser/daksh
	@PutMapping(value = "/updateUser/{userName}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> updateUserById(@Valid @RequestBody User user, @PathVariable("userName") String userName)
			throws NoSuchUserException {
		return new ResponseEntity<>(service.updateUserByUserName(user, userName), HttpStatus.OK);
	}

	
	@PutMapping("/forgetPassword/{email}")
	public ResponseEntity<User> changePassword(@Valid @RequestBody User user, @PathVariable("email") String email)
			throws NoSuchUserException {
		return new ResponseEntity<>(service.changePassword(user, email), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<User> searchByEmail(@PathVariable("email") String email) {
		return new ResponseEntity<>(service.getUserByEmail(email), HttpStatus.FOUND);
	}
	
	//http://localhost:8080/EgiftCardApp/userservice/daksh
	@DeleteMapping("/{userName}")
	public ResponseEntity<String> deleteUserById(@PathVariable("userName") String userName) throws NoDataException {
		if (userName == null)
			throw new NoDataException("Data not available");
		else {
			service.deleteUserByUserName(userName);
			return new ResponseEntity<>("Deleted user with id " + userName + " successfully", HttpStatus.OK);
		}
	}
}
