package edu.uces.ar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uces.ar.model.User;

@Controller
public class RecoveryUserController {

	public RecoveryUserController() {
		super();
	}


	@GetMapping("showRecoveryUser")
	public String showRecoveryUser() {
		
		return "RecoveryUser";
	}
	
	@PostMapping("sendRecoveryUser")
	public String sendRecoveryUser(@RequestParam(value="name", required=true) String name) {
		
		//TODO logica de envio de email
		
		return "RecoveryUserSent";
	}
	
	@GetMapping("showRecoveryUserForm")
	public String showRecoveryUserForm(Model model) {
		
		//TODO buscar el usuario mediante el link enviado y agregarlo al modelo
		User admin = new User();
		admin.setName("admin");
		model.addAttribute(admin);
		
		return "RecoveryUserForm";
	}
	
	@PostMapping("submitRecoveryUserForm")
	public String recoveryUser(Model model, @ModelAttribute("user") User user) {
		
		//TODO logica de validacion de user + link + liberacion si esta bloqueada + cambio de pass
		
		return "RecoveryUserFormSubmit";
	}
	
}
