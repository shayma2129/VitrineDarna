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

import com.darna.dto.InformationContactDto;
import com.darna.models.InformationContact;
import com.darna.services.InformationContactService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/InformationContact")
public class InformationContactController {
	
	@Autowired
	InformationContactService informationContactService ;
	@Autowired
	ModelMapper modelMapper;
	
	
	@PostMapping("/saveInformationContact")
	public Object addInformationContact(@Valid @RequestBody  InformationContactDto informationContactDto) {
		InformationContact informationContact=modelMapper.map(informationContactDto, InformationContact.class);
		informationContact =informationContactService.addInformationContact(informationContact);
		informationContactDto =modelMapper.map(informationContact, InformationContactDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(informationContactDto);
	}
	
	@GetMapping(value = "/listInformationContact")
	public List<InformationContact> findAll() {
		return informationContactService.findAllItems();
	}

	@PutMapping(value="/update/{id}")
    public InformationContact updateInformationContact(@PathVariable("id") long id,@RequestBody InformationContact informationContact) {
		informationContactService.updateInformationContact(id,informationContact);
    	 return informationContact;
    }

	  @GetMapping(value ="/element/{id}")
		public InformationContact findbyidElement(@PathVariable("id") long id) {
			return informationContactService.findbyid(id);

		}
	 
	  
	 @DeleteMapping("/elementDelete/{id}")
	    public Object deleteElement(@PathVariable("id")Long id )
	    {
		 informationContactService.deleteInformationContact(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	    }

	 
	 
}
