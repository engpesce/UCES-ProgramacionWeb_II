package edu.uces.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uces.ar.model.IceCream;

@Repository
public interface IceCreamRepository extends JpaRepository<IceCream, Long> {
	
}
