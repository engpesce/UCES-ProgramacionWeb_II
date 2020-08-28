package edu.uces.ar.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.uces.ar.model.Privilege;
import edu.uces.ar.model.Role;
import edu.uces.ar.model.User;
import edu.uces.ar.model.dto.UserDTO;
import edu.uces.ar.repository.RoleRepository;
import edu.uces.ar.repository.UserRepository;
import edu.uces.ar.service.JwtUserDetailsService;
import edu.uces.ar.service.business.exception.UserAlreadyExistException;

@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> response = userRepository.findByEmail(email);
		if (!response.isPresent()) {
			throw new UsernameNotFoundException("User not found with username: " + email);
		}
		User user = response.get();
		return new org.springframework.security.core.userdetails.User(
		          user.getEmail(), user.getPassword(), user.isEnabled(), true, true, 
		          true, getAuthorities(user.getRoles()));
	}
	
	public User registerNewUserAccount(final UserDTO accountDto) {
		  
		if (emailExists(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
        }
        final User user = new User();

        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(bcryptEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        user.setEnabled(true);
        return userRepository.save(user);
	}
	
	private boolean emailExists(final String email) {
        return userRepository.findByEmail(email).isPresent();
    }
	
	private Collection<? extends GrantedAuthority> getAuthorities(
		      Collection<Role> roles) {
		  
		        return getGrantedAuthorities(getPrivileges(roles));
		    }
		 
		    private List<String> getPrivileges(Collection<Role> roles) {
		  
		        List<String> privileges = new ArrayList<>();
		        List<Privilege> collection = new ArrayList<>();
		        for (Role role : roles) {
		            collection.addAll(role.getPrivileges());
		        }
		        for (Privilege item : collection) {
		            privileges.add(item.getName());
		        }
		        return privileges;
		    }
		 
		    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		        List<GrantedAuthority> authorities = new ArrayList<>();
		        for (String privilege : privileges) {
		            authorities.add(new SimpleGrantedAuthority(privilege));
		        }
		        return authorities;
		    }
}