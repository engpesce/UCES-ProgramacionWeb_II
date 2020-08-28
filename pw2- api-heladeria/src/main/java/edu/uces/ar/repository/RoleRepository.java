package edu.uces.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uces.ar.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
