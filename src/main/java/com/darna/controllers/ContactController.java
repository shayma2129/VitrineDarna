package com.darna.controllers;

import java.util.List;
import java.util.Random;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darna.dto.ContactDto;
import com.darna.models.Contact;
import com.darna.response.MessageResponse;
import com.darna.services.ContactService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Contact")
public class ContactController {
	
	
	@Autowired
	ContactService contactService ;
	@Autowired
	ModelMapper modelMapper;
	   int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 5;
	    Random random = new Random();
	    String generatedString;
	@GetMapping("/genererCode")
	public void givenUsingJava8_whenGeneratingRandomAlphabeticString_thenCorrect() {
	 
	 
	     generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    System.out.println(generatedString);
	}

	@PostMapping("/envoyer")
	public Object envoyer(@Valid @RequestBody  ContactDto contactDto) {
		Contact contact=modelMapper.map(contactDto, Contact.class);
	
		if(contactDto.getCode().equals(generatedString)) {
			contact =contactService.addContact(contact);
			contactDto =modelMapper.map(contact, ContactDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(contactDto);}
		else {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error:code false!"));
		}
	}
	
	
	@GetMapping(value = "/listContact")
	public List<Contact> findAll() {
		return contactService.findAllItems();
	}


	  @GetMapping(value ="/element/{id}")
		public Contact findbyidElement(@PathVariable("id") long id) {
			return contactService.findbyid(id);

		}
	 
	  
	 @DeleteMapping("/elementDelete/{id}")
	    public Object deleteElement(@PathVariable("id")Long id )
	    {
		 contactService.deleteContact(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	    }

	 
	 

	
	

}
