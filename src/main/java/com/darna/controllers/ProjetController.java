package com.darna.controllers;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.darna.dto.ProjetDto;
import com.darna.models.Projet;
import com.darna.services.ProjetService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController()
public class ProjetController {
	
	@Autowired
	private ProjetService projetService;
	
	@Autowired
	ModelMapper modelMapper;
	
	private static String UPLOAD_DIR ="C:\\wamp64\\www\\darna_app\\projets";

	

	@PostMapping("/api/Addprojet")
	public Object addProjet(@RequestParam(name="data",required = false) String data,@RequestParam("image") MultipartFile image)throws Exception,IOException,JsonParseException , JsonMappingException  {
		Projet projet=new ObjectMapper().readValue(data, Projet.class);
		String filename= image.getOriginalFilename();
        String modifiedFileName=FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
		projet.setImage(image.getBytes());
		projet.setPath_image(modifiedFileName);
	    Path rootLocation = Paths.get(UPLOAD_DIR);
	    Files.copy(image.getInputStream(), rootLocation.resolve(modifiedFileName));
	    projet=projetService.addProjet(projet);
	    ProjetDto sponsorDto=modelMapper.map(projet,ProjetDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(sponsorDto);
	}
	
	
	
	
	
	@PutMapping("/api/update/{idP}")
	public Object updateProjet(@RequestParam(name="data",required = false) String data,@RequestParam("image") MultipartFile image,@PathVariable("idP") Long idP)throws Exception,IOException,JsonParseException , JsonMappingException  {
		Projet projet=new ObjectMapper().readValue(data, Projet.class);
		String filename= image.getOriginalFilename();
        String modifiedFileName=FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
        projet.setImage(image.getBytes());
        projet.setPath_image(modifiedFileName);
	    Path rootLocation = Paths.get(UPLOAD_DIR);
	    Files.copy(image.getInputStream(), rootLocation.resolve(modifiedFileName));
	    projet=projetService.updateProjet(projet, idP);
	    ProjetDto projetDto=modelMapper.map(projet,ProjetDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(projetDto);
	}
	
	@GetMapping("/api/listProjet")
	public Object getAllProjet()
	{
	    List <Projet> listprojet = projetService.getAllProjet();
		Type listType = new TypeToken<List<ProjetDto>>() {}.getType();
		List<ProjetDto> listProjetDto = modelMapper.map(listprojet,listType);
		return ResponseEntity.status(HttpStatus.OK).body(listProjetDto);
	}
	
	@DeleteMapping("/api/projet/{idP}")
    public Object deleteProjet(@PathVariable("idP")Long idP )
    {
		projetService.deleteProjet(idP);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
	@GetMapping("/api/projet/{idP}")
	public Object getSponsorById(@PathVariable("idP") Long idP)
    {
		Projet projet=projetService.getProjetById(idP);
		ProjetDto projetDto=modelMapper.map(projet,ProjetDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(projetDto);
    }
	

}
