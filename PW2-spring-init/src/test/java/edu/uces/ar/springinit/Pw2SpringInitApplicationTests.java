package edu.uces.ar.springinit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.uces.ar.service.MailService;

@SpringBootTest
class Pw2SpringInitApplicationTests {
	
	@Autowired
	MailService mailService;
	
	@Test
	void emailSend() {
		
		mailService.sendSimpleMessage("profesor.german.pesce@gmail.com", "Enviando Mail desde Spring", "Probando probando!");
		
	}
	
	@Test
	void generateURLwithUUID() throws MalformedURLException {
		
		URL urlBase = new URL("http://localhost:8080");
		String controllerPath = "/recuperarUsuario/key=";
		UUID uuid = UUID.randomUUID();
		
		System.out.println(urlBase + controllerPath + uuid);
	}

}
