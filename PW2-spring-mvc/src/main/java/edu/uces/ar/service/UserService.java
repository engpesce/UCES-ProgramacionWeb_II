package edu.uces.ar.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.uces.ar.model.User;
import edu.uces.ar.repository.UserRepository;

@Service
public class UserService {

	private UserRepository repository;
	
	public UserService(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Transactional
	public boolean createUser(User user) {
		
		if (user.getName() != null && user.getPassword() != null) {
			repository.save(user);
			return true;
		} else {
			return false;
		}
		
	}
	
}
