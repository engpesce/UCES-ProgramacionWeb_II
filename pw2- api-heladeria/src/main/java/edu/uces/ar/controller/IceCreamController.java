package edu.uces.ar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uces.ar.model.dto.IceCreamDTO;
import edu.uces.ar.service.IceCreamService;

@RestController
@Validated
public class IceCreamController {
	
	private final IceCreamService service;
	
	public IceCreamController(IceCreamService service) {
		super();
		this.service = service;
	}

	@GetMapping(value = "/iceCreams")
	public ResponseEntity<List<IceCreamDTO>> getIceCreams() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/iceCreams/{id}")
	public ResponseEntity<IceCreamDTO> getIceCream(@PathVariable long id) {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}

	@PostMapping(path = "/iceCreams")
	public ResponseEntity<Object> postProduct(@Valid @RequestBody IceCreamDTO iceCreamDTO) {
		Long id = service.post(iceCreamDTO);
		return new ResponseEntity<>("Ice Cream successfully created. Id: " + id, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/iceCreams/{id}")
	public ResponseEntity<Object> putProduct(@PathVariable long id, @Valid @RequestBody IceCreamDTO iceCreamDTO) {
		iceCreamDTO.setId(id);
		service.put(iceCreamDTO);
		return new ResponseEntity<>("Ice Cream successfully updated. Id: " + id, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/iceCreams/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable long id) {
		service.deleteById(id);
		return new ResponseEntity<>("Ice Cream deleted successfully. Id: " + id, HttpStatus.OK);
	}

}
