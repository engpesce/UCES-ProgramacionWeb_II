package edu.uces.ar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import edu.uces.ar.model.User;

@Repository
public class UserRepository {

	private List<User> usuariosCreados = new ArrayList<>();
	
	public User save(User user) {
		
		usuariosCreados.add(user);
		
		return user;
	}
	
	
	public User findById(String nombreUsuario) {
		//esto es lo mismo que un for pero con programacion funcional
		Optional<User> usuarioRecuperado = usuariosCreados.stream().filter(user -> user.getName().equals(nombreUsuario)).findFirst();
		
		return usuarioRecuperado.orElse(null);
	}
	
}

