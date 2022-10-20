package com.egiftcard.service;

import java.util.HashSet;
import java.util.Set;import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.egiftcard.entity.JWTRequest;
import com.egiftcard.entity.JwtResponse;
import com.egiftcard.entity.User;
import com.egiftcard.repository.UserRepository;
import com.egiftcard.util.JWTUtil;

@Service
public class JWTService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public JwtResponse createJwtToken(JWTRequest jwtRequest) throws Exception {
		String userName= jwtRequest.getUserName();
		String password=jwtRequest.getPassword();
		authenticate(userName, password);
		final UserDetails userDetails= loadUserByUsername(userName);
		String newGeneratedToken= jwtUtil.generateToken(userDetails);
		User user = userRepo.findById(userName).get();
		return new JwtResponse(user, newGeneratedToken);
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userRepo.findById(username).get();
		if(user!=null) {
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthorities(user));
		}else {
			throw new UsernameNotFoundException("Username is not Valid");
		}
	}
	
	private Set getAuthorities(User user) {
		Set authorities= new HashSet();
		user.getRole().forEach(role->{
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));		
		});
		return authorities;
	}
	
	private void authenticate(String userName,String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		}
		catch(DisabledException e){
			throw new Exception("User is disabled");
		}
		catch(BadCredentialsException e) {
			throw new Exception("Bad Credentials");
		}
		
	}
}
