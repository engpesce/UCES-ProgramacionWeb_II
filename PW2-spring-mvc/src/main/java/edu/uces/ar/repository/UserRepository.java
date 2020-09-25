package edu.uces.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uces.ar.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByName(String userName);

}
