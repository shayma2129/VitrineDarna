package com.darna.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")

public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('RESPONSABLE') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
			
		
	}

	/*@GetMapping("/mod")
	@PreAuthorize("hasRole('RESPONSABLE')")
	public String moderatorAccess() {
		return "Responsable Board.";
	}*/

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@GetMapping("/responsable")
	@PreAuthorize("hasRole('RESPONSABLE')")
	public String responsableAccess() {
		return "Responsable Board.";
	}
	@GetMapping("/eleve")
	@PreAuthorize("hasRole('ELEVE')")
	public String eleveAccess() {
		return "eleve Board.";
	}
	@GetMapping("/enseignant")
	@PreAuthorize("hasRole('ENSEIGNANT')")
	public String enseignantAccess() {
		return "Enseignant Board.";
	}
	
	@GetMapping("/expert")
	@PreAuthorize("hasRole('EXPERT')")
	public String expertAccess() {
		return "expert Board.";
	}
	
	@GetMapping("/apprenant")
	@PreAuthorize("hasRole('APPRENANT')")
	public String apprenantAccess() {
		return "apprenant Board.";
	}
	
}
