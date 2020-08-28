package edu.uces.ar.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import edu.uces.ar.model.User;
import edu.uces.ar.model.dto.UserDTO;

@Service
public interface JwtUserDetailsService extends UserDetailsService{

	User save(UserDTO user);
	
}
