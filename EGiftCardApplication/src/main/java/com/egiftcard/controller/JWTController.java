package com.egiftcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard.entity.JWTRequest;
import com.egiftcard.entity.JwtResponse;
import com.egiftcard.service.JWTService;

@RestController
@CrossOrigin
//@RequestMapping("/jwt")
public class JWTController {
	
		@Autowired
		private JWTService jwtService;

		@PostMapping({"/authenticate"})
		public JwtResponse createJwtToken(@RequestBody JWTRequest jwtRequest) throws Exception {
			return jwtService.createJwtToken(jwtRequest);
		}
}
