package com.darna.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

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

import com.darna.dto.PresentationDto;
import com.darna.models.Presentation;
import com.darna.services.PresentationService;

@CrossOrigin("*")
@RestController()
public class PresentationController {
	
	@Autowired
	private PresentationService presentationService;
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping("/api/presentation")
	public Object addPresentation(@Valid @RequestBody PresentationDto presentationDto) {
		Presentation presentation=modelMapper.map(presentationDto, Presentation.class);
		presentation =presentationService.addPresentation(presentation);
		presentationDto =modelMapper.map(presentation, PresentationDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(presentationDto);
	}
	@PutMapping("/api/oldpresentation/{idP}")
	public Object updatePresentation(@Valid @RequestBody PresentationDto presentationDto, @PathVariable("idP") Long idP) {
		Presentation presentation=modelMapper.map(presentationDto, Presentation.class);
		presentation = presentationService.updatePresentation(presentation, idP);
		presentationDto = modelMapper.map(presentation, PresentationDto.class);
	return ResponseEntity.status(HttpStatus.CREATED).body(presentationDto);
	}

	@GetMapping("/api/listpresentation")
	public Object getAllPresentation()
	{
		List <Presentation> listpresentation = presentationService.getAllPresentation();
		
		Type listType = new TypeToken<List<PresentationDto>>() {}.getType();
		List<PresentationDto> listpresdtos = modelMapper.map(listpresentation,listType);
		return ResponseEntity.status(HttpStatus.OK).body(listpresdtos);
	}
	@DeleteMapping("/api/deletepresentation/{idP}")
    public Object deletePresentation(@PathVariable("idP")Long idP )
    {
		presentationService.deletePresentation(idP);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
	@GetMapping("/api/Presentation/{idP}")
	public Object getPresentationById(@PathVariable("idP") Long idP)
    {
		Presentation presentation=presentationService.getPresentationById(idP);
		PresentationDto presentationDto=modelMapper.map(presentation,PresentationDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(presentationDto);
    }

}
