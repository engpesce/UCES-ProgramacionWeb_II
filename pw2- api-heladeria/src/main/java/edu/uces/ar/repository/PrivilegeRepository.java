package edu.uces.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uces.ar.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}
