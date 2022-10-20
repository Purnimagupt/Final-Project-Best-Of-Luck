package com.egiftcard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard.entity.UserGiftDetails;
import com.egiftcard.exception.DuplicateUserGiftDetailsIdException;
import com.egiftcard.exception.UserGiftDetailsNotFoundException;
import com.egiftcard.service.IUserGiftDetailsAccountManagementService;

//@RestController annotation is a special controller used in RESTful Web services, 
//and it’s the combination of @Controller and @ResponseBody annotation.
@RestController

//@RequestMapping annotation for mapping all the incoming HTTP request URLs to the corresponding controller methods.
@RequestMapping("/usergiftdetails")
@CrossOrigin
public class UserGiftDetailsAccountManagementController {

//The @Autowired annotation marks a Constructor, Setter method, Properties and Config() method as to be autowired 
//that is ‘injecting beans'(Objects) at runtime by Spring Dependency Injection
	@Autowired
	private IUserGiftDetailsAccountManagementService userGiftDetailsManagementService;

	public UserGiftDetailsAccountManagementController(
			IUserGiftDetailsAccountManagementService userGiftDetailsAcccountManagementService) {
		super();
		this.userGiftDetailsManagementService = userGiftDetailsAcccountManagementService;
	}

	// @RequestMapping(method = RequestMethod.GET)
	//http://localhost:8080/EgiftCardApp/usergiftdetails
	@GetMapping
	public List<UserGiftDetails> getAllUserGiftDetails() {
		return userGiftDetailsManagementService.getAllUserGiftDetails();
	}

	@GetMapping("{user_gift_id}")
	public ResponseEntity<UserGiftDetails> getUserGiftDetails(@PathVariable("user_gift_id") int userGiftId)
			throws UserGiftDetailsNotFoundException {
		return new ResponseEntity<>(userGiftDetailsManagementService.getUserGiftDetails(userGiftId), HttpStatus.OK);
	}

	// @RequestMapping(method = RequestMethod.POST)

	// The @RequestBody annotation is responsible for binding the HTTPRequest body
	// to the body of the web request.
	// @Valid annotation to automatically validate the input.
	@PostMapping
	public ResponseEntity<UserGiftDetails> addUserGiftDetails(@Valid @RequestBody(required = false) UserGiftDetails u)
			throws DuplicateUserGiftDetailsIdException {
		return new ResponseEntity<>(userGiftDetailsManagementService.addUserGiftDetails(u), HttpStatus.CREATED);
	}

	// @RequestMapping(method = RequestMethod.PUT)
	
	// @PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable.
	@PutMapping("/{user_gift_id}")
	public ResponseEntity<UserGiftDetails> updateUserGiftDetailsById(@PathVariable("user_gift_id") int userGiftId,
			@Valid @RequestBody(required = false) UserGiftDetails userGiftDetails)
			throws UserGiftDetailsNotFoundException {
		return new ResponseEntity<>(
				userGiftDetailsManagementService.updateUserGiftDetailsById(userGiftDetails, userGiftId), HttpStatus.OK);
	}

	// @RequestMapping(method =RequestMethod.DELETE)

	@DeleteMapping("/{user_gift_id}")
	public String deleteUserGiftDetailsById(@PathVariable("user_gift_id") int userGiftId)
			throws UserGiftDetailsNotFoundException {
		userGiftDetailsManagementService.deleteUserGiftDetailsById(userGiftId);
		return "Deleted Successfully!";
	}

}
