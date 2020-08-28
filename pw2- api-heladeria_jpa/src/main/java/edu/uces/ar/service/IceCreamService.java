package edu.uces.ar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uces.ar.model.dto.IceCreamDTO;

@Service
public interface IceCreamService {

	List<IceCreamDTO> getAll();
	
	IceCreamDTO getById(Long id);
	
	Long post(IceCreamDTO iceCream);
	
	Long put(IceCreamDTO iceCream);
	
	void deleteById(Long id);
}
