package edu.uces.ar.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import edu.uces.ar.model.IceCream;
import edu.uces.ar.model.dto.IceCreamDTO;
import edu.uces.ar.repository.IceCreamRepository;
import edu.uces.ar.service.IceCreamService;
import edu.uces.ar.service.business.exception.IceCreamNotFoundException;

@Service
public class IceCreamServiceImpl implements IceCreamService{
	
	private final IceCreamRepository iceCreamRepo;
	
	public IceCreamServiceImpl(IceCreamRepository iceCreamRepo) {
		super();
		this.iceCreamRepo = iceCreamRepo;
	}

	@Override
	public List<IceCreamDTO> getAll() {

		List<IceCream> iceCreams = iceCreamRepo.findAll();
		List<IceCreamDTO> dtos = new ArrayList<>(iceCreams.size());
		
		//mapeo de listas
		for (int i = 0; i < iceCreams.size(); i++) {
			IceCreamDTO iceCreamDTO = new IceCreamDTO();
			BeanUtils.copyProperties(iceCreams.get(i), iceCreamDTO);
			dtos.add(iceCreamDTO);
		}
		
		return dtos;
	}

	@Override
	public IceCreamDTO getById(Long id) {
		
		Optional<IceCream> iceCream = iceCreamRepo.findById(id);
		IceCreamDTO dto = new IceCreamDTO();
		
		if (iceCream.isPresent()) {
			BeanUtils.copyProperties(iceCream.get(), dto);
		} else {
			throw new IceCreamNotFoundException("Ice Cream " + id + " not found");
		}
		
		return dto;
	}
	
	@Override
	public Long post(IceCreamDTO iceCreamDTO) {

		IceCream iceCream = new IceCream();
		BeanUtils.copyProperties(iceCreamDTO, iceCream);
		iceCream = iceCreamRepo.save(iceCream);
		
		return iceCream.getId();
	}

	@Override
	public Long put(IceCreamDTO iceCreamDTO) {

		IceCream iceCream = new IceCream();
		BeanUtils.copyProperties(iceCreamDTO, iceCream);
		iceCream = iceCreamRepo.save(iceCream);
		
		return iceCream.getId();
	}

	@Override
	public void deleteById(Long id) {
		iceCreamRepo.deleteById(id);
	}

}
