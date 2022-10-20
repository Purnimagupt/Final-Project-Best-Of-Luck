//package com.egiftcard.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.egiftcard.entity.User;
//import com.egiftcard.exception.InvalidUserIdException;
//import com.egiftcard.exception.NoDataException;
//import com.egiftcard.exception.NoSuchUserException;
//import com.egiftcard.service.IUserManagementService;
//
//@RestController
//@RequestMapping("/userservice")
//public class UserManagementServiceController {
//	@Autowired
//	private IUserManagementService userService;
//
//	@GetMapping
//	public ResponseEntity<List<User>> getAllUsers() throws NoDataException {
//		List<User> user = userService.getAllUsers();
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}
//
//	@GetMapping("/getUserById/{userId}")
//	public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) throws NoSuchUserException {
//		User user = userService.getUserById(userId);
//
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}
//
//	@GetMapping("/getUserByFirstName/{firstName}")
//	public ResponseEntity<User> searchByFirstName(@PathVariable("firstName") String firstName) {
//
//		return new ResponseEntity<>(userService.searchByFirstName(firstName), HttpStatus.FOUND);
//	}
//
//	@GetMapping("/getUserByEmail/{email}")
//	public ResponseEntity<User> searchByEmail(@PathVariable("email") String email) {
//		return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.FOUND);
//	}
//
//	@PutMapping(value = "/updateUser/{userId}", consumes = "application/json", produces = "application/json")
//	public ResponseEntity<User> updateUserById(@Valid @RequestBody User user, @PathVariable("userId") int userId)
//			throws NoSuchUserException {
//		return new ResponseEntity<>(userService.updateUserById(user, userId), HttpStatus.OK);
//	}
//
//	@PutMapping("/forgetPassword/{email}")
//	public ResponseEntity<User> changePassword(@Valid @RequestBody User user, @PathVariable("email") String email)
//			throws NoSuchUserException {
//		return new ResponseEntity<>(userService.changePassword(user, email), HttpStatus.NOT_FOUND);
//	}
//
//	@PostMapping
//	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws InvalidUserIdException {
//		return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
//	}
//
//	@DeleteMapping("/{userid}")
//	public ResponseEntity<String> deleteUserById(@PathVariable("userid") int userId) throws NoDataException {
//		if (userId == 0)
//			throw new NoDataException("Data not available");
//		else {
//			userService.deleteUserById(userId);
//			return new ResponseEntity<>("Deleted user with id " + userId + " successfully", HttpStatus.OK);
//		}
//	}
//}
