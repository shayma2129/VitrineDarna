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

import com.darna.dto.SponsorDto;
import com.darna.models.Sponsor;
import com.darna.services.SponsorService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController()
public class SponsorController {
	
	@Autowired
	private SponsorService sponsorService;
	
	@Autowired
	ModelMapper modelMapper;
	
	private static String UPLOAD_DIR ="C:\\wamp64\\www\\darna_app\\sponsors";

	
	@PostMapping("/api/sponsor")
	public Object addSponsor(@RequestParam(name="data",required = false) String data,@RequestParam("logo") MultipartFile logo)throws Exception,IOException,JsonParseException , JsonMappingException  {
		Sponsor sponsor=new ObjectMapper().readValue(data, Sponsor.class);
		String filename= logo.getOriginalFilename();
		String modifiedFileName="LOGO_"+sponsor.getIntitule_sponsor()+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
        sponsor.setLogo(logo.getBytes());
        sponsor.setPath_logo(modifiedFileName);
	    Path rootLocation = Paths.get(UPLOAD_DIR);
	    Files.copy(logo.getInputStream(), rootLocation.resolve(modifiedFileName));
	    sponsor=sponsorService.addSponsor(sponsor);
	    SponsorDto sponsorDto=modelMapper.map(sponsor,SponsorDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(sponsorDto);
	}
	@PutMapping("/api/oldSponsor/{idS}")
	public Object updateObjectif(@RequestParam(name="data",required = false) String data,@RequestParam("logo") MultipartFile logo,@PathVariable("idS") Long idS)throws Exception,IOException,JsonParseException , JsonMappingException  {
		Sponsor sponsor=new ObjectMapper().readValue(data, Sponsor.class);
		String filename= logo.getOriginalFilename();
		String modifiedFileName="LOGO_"+sponsor.getIntitule_sponsor()+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
        sponsor.setLogo(logo.getBytes());
        sponsor.setPath_logo(modifiedFileName);
	    Path rootLocation = Paths.get(UPLOAD_DIR);
	    Files.copy(logo.getInputStream(), rootLocation.resolve(modifiedFileName));
	    sponsor=sponsorService.updateSponsor(sponsor, idS);
	    SponsorDto sponsorDto=modelMapper.map(sponsor,SponsorDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(sponsorDto);
	}

	@GetMapping("/api/listSponsor")
	public Object getAllSponsor()
	{
		List <Sponsor> listsponsor = sponsorService.getAllSponsor();
		Type listType = new TypeToken<List<SponsorDto>>() {}.getType();
		List<SponsorDto> listsponsordtos = modelMapper.map(listsponsor,listType);
		return ResponseEntity.status(HttpStatus.OK).body(listsponsordtos);
	}
	@DeleteMapping("/api/sponsor/{idS}")
    public Object deleteSponsor(@PathVariable("idS")Long idS )
    {
		sponsorService.deleteSponsor(idS);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
	@GetMapping("/api/Sponsor/{idS}")
	public Object getSponsorById(@PathVariable("idS") Long idS)
    {
		Sponsor sponsor=sponsorService.getSponsorById(idS);
		SponsorDto sponsorDto=modelMapper.map(sponsor,SponsorDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(sponsorDto);
    }

}
