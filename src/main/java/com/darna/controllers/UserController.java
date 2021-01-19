package com.darna.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.darna.models.Role;
import com.darna.models.User;
import com.darna.repository.UserRepository;
import com.darna.response.MessageResponse;
import com.darna.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/UserMethode")
public class UserController {

	@Autowired
	UserService userService;


	@Autowired
	UserRepository userRepository;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/listUser")
	public List<User> findAll() {
		return userService.findAll();

	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/SearchByrole", method = RequestMethod.GET)
	public List<User> getbyrole()  {
		
		List<Role> roles = null;
		return userRepository.findBySpecificRoles(roles);
	}
	
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/activate/{id}")
	public MessageResponse activate(@PathVariable Long id) {
		return userService.activate(id);
	}
	
	
	
	
}
