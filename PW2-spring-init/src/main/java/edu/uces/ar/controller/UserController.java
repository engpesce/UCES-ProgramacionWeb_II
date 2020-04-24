package edu.uces.ar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.uces.ar.model.User;
import edu.uces.ar.service.UserService;

@Controller
public class UserController {
	
	UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping({"/createUser"})
    public String showCreateUser(Model model) {
		model.addAttribute("user", new User()); 
		return "CreateUser";
    }
	
	@PostMapping({"/createUser"})
    public String createUser(Model model, @ModelAttribute("user") User user) {

		boolean wasCreated = userService.createUser(user);
		
		if (wasCreated) {
			model.addAttribute("isValid", true);
			
			return "Login";
		} else {
			model.addAttribute("isValid", false);
			
			return "CreateUser";
		}
		
		
    }
}
