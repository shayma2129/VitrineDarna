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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darna.dto.RebriqueAiderDto;
import com.darna.models.RebriqueAider;
import com.darna.services.RebriqueAiderService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Aider")
public class RebriqueAiderController {
	
	@Autowired
	 RebriqueAiderService rebriqueAiderService ;
	@Autowired
	ModelMapper modelMapper;
	
	
	@PostMapping("/saveAider")
	public Object Aider(@Valid @RequestBody  RebriqueAiderDto rebriqueAiderDto) {
		RebriqueAider rebriqueAider=modelMapper.map(rebriqueAiderDto, RebriqueAider.class);
		rebriqueAider =rebriqueAiderService.addRebriqueAider(rebriqueAider);
		rebriqueAiderDto =modelMapper.map(rebriqueAider, RebriqueAiderDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(rebriqueAiderDto);
	}
	
	
	@GetMapping(value = "/listAider")
	public List<RebriqueAider> findAll() {
		return rebriqueAiderService.findAllItems();
	}

	@PutMapping(value="/update/{id}")
    public RebriqueAider updateRebriqueAider(@PathVariable("id") long id,@RequestBody RebriqueAider rebriqueAider) {
		rebriqueAiderService.updateRebrique(id,rebriqueAider);
    	 return rebriqueAider;
    }

   @GetMapping(value ="/element/{id}")
	public RebriqueAider findbyidElement(@PathVariable("id") long id) {
		return rebriqueAiderService.findbyid(id);

	}
   
	@DeleteMapping("/elementDelete/{id}")
    public Object deleteElement(@PathVariable("id")Long id )
    {
		rebriqueAiderService.deleteRebriqueAider(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
