package edu.uces.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uces.ar.model.IceCream;

public interface IceCreamRepository extends JpaRepository<IceCream, Long> {

	
}
