package com.darna.controllers;

import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.darna.dto.ObjectifDto;
import com.darna.models.Objectif;
import com.darna.services.ObjectifService;

@CrossOrigin("*")
@RestController()
public class ObjectifController {
	
	@Autowired
	private ObjectifService objectifService;
	@Autowired
	ModelMapper modelMapper;
	
	
	@PostMapping("/api/objectif")
	public Object addObjectif(@Valid @RequestBody ObjectifDto objectifDto) {
		Objectif objectif=modelMapper.map(objectifDto, Objectif.class);
		objectif =objectifService.addObjectif(objectif);
		objectifDto =modelMapper.map(objectif, ObjectifDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(objectifDto);
	}
	@PutMapping("/api/oldObjectif/{idO}")
	public Object updateObjectif(@Valid @RequestBody ObjectifDto objectifDto, @PathVariable("idO") Long idO) {
		Objectif objectif=modelMapper.map(objectifDto, Objectif.class);
		objectif = objectifService.updateObjectif(objectif, idO);
		objectifDto = modelMapper.map(objectif, ObjectifDto.class);
	return ResponseEntity.status(HttpStatus.CREATED).body(objectifDto);
	}

	@GetMapping("/api/listObjectif")
	public Object getAllObjectif()
	{
		List <Objectif> listobjectif = objectifService.getAllObjectif();
		return ResponseEntity.status(HttpStatus.OK).body(listobjectif);
	}
	@DeleteMapping("/api/deleteObjectif/{idO}")
    public Object deleteObjectif(@PathVariable("idO")Long idO )
    {
		objectifService.deleteObjectif(idO);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
	@GetMapping("/api/Objectif/{idO}")
	public Object getObjectifById(@PathVariable("idO") Long idO)
    {
		Objectif objectif=objectifService.getObjectifById(idO);
		return ResponseEntity.status(HttpStatus.OK).body(objectif);
    }

}
