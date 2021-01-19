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

import com.darna.dto.DocumentDto;
import com.darna.dto.LienDocDto;
import com.darna.models.Document;
import com.darna.models.LienDoc;
import com.darna.services.DocumentService;
import com.darna.services.LienDocService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController()
public class LienDocController {

	@Autowired
	private LienDocService liendocService;
	@Autowired
	private DocumentService documentService;
	@Autowired
	ModelMapper modelMapper;
	
	private static String UPLOAD_DIR ="C:\\wamp64\\www\\darna_app\\documents\\pdf";


	@PostMapping("/api/LienDoc")
	public Object saveLienDoc(@RequestParam(name="data",required = false) String data,@RequestParam("file[]") MultipartFile[] file)throws Exception,IOException,JsonParseException , JsonMappingException {
		LienDoc liendoc=new ObjectMapper().readValue(data, LienDoc.class);
		LienDoc liendocBD=liendocService.addLienDoc(liendoc);
		
	    	 for(int i=0;i<file.length;i++) {
				   Document document = new Document();
		           document.setFile(file[i].getBytes());
			       String filename= file[i].getOriginalFilename();
			       String modifiedFileName=FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
			       document.setPath_doc(modifiedFileName);
			       Path rootLocation = Paths.get(UPLOAD_DIR);
			       Files.copy(file[i].getInputStream(), rootLocation.resolve(modifiedFileName));
			       document.setLienDoc(liendoc);
			       documentService.addDocument(document);
			   }
	       
	       LienDocDto liendocDto=modelMapper.map(liendocBD,LienDocDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(liendocDto);
	}
	
	@PutMapping("/api/oldLienDoc/{idL}")
	public Object updateLienDoc(@RequestParam(name="data",required = false) String data,@RequestParam("file[]") MultipartFile[] file,@PathVariable("idL") Long idL)throws Exception,IOException,JsonParseException , JsonMappingException {
		LienDoc liendoc=new ObjectMapper().readValue(data, LienDoc.class);
		LienDoc liendocBD=liendocService.updateLienDoc(liendoc, idL);
	
	    	 documentService.deleteAllDocLienDoc(idL);
	    	 for(int i=0;i<file.length;i++) {
				   Document document = new Document();
		           document.setFile(file[i].getBytes());
			       String filename= file[i].getOriginalFilename();
			       String modifiedFileName=FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
			       document.setPath_doc(modifiedFileName);
			       Path rootLocation = Paths.get(UPLOAD_DIR);
			       Files.copy(file[i].getInputStream(), rootLocation.resolve(modifiedFileName));
			       document.setLienDoc(liendoc);
			       documentService.addDocument(document);
			   }
	        
	       LienDocDto liendocDto=modelMapper.map(liendocBD,LienDocDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(liendocDto);
	}

	@GetMapping("/api/listLienDoc")
	public Object getAllLienDoc()
	{
		List <LienDoc> listliendoc = liendocService.getAllLienDoc();
		Type listType = new TypeToken<List<LienDocDto>>() {}.getType();
		List<LienDocDto> listliendocdtos = modelMapper.map(listliendoc,listType);
		return ResponseEntity.status(HttpStatus.OK).body(listliendocdtos);
	}
	@DeleteMapping("/api/deleteLiendoc/{idL}")
    public Object deleteLienDoc(@PathVariable("idL")Long idL )
    {
		liendocService.deleteLienDoc(idL);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
	@GetMapping("/api/LienDoc/{idL}")
	public Object getLienDocById(@PathVariable("idL") Long idL)
    {
		LienDoc liendoc=liendocService.getLienDocById(idL);
		LienDocDto liendocDto=modelMapper.map(liendoc,LienDocDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(liendocDto);
    }
	@GetMapping("/api/documents/{idL}")
	public Object getAllDocByIdliendoc(@PathVariable("idL") Long idL)
    {
		List<Document> listdocuments=liendocService.getAllDocByIdLienDoc(idL);
		Type listType = new TypeToken<List<DocumentDto>>() {}.getType();
		List<DocumentDto> listliendocdtos = modelMapper.map(listdocuments,listType);
		return ResponseEntity.status(HttpStatus.OK).body(listliendocdtos);
    }
	@GetMapping("/api/DernieresEtudes")
	public Object getAllDernierEtude()
	{
		List <Document> listliendoc = liendocService.getAllDernierEtude();
		Type listType = new TypeToken<List<DocumentDto>>() {}.getType();
		List<DocumentDto> listliendocdtos = modelMapper.map(listliendoc,listType);
		return ResponseEntity.status(HttpStatus.OK).body(listliendocdtos);
	}
	@GetMapping("/api/DroitEnfant")
	public Object getAllDroitEnfant()
	{
		List <Document> listliendoc = liendocService.getAllDroitEnfant();
		Type listType = new TypeToken<List<DocumentDto>>() {}.getType();
		List<DocumentDto> listliendocdtos = modelMapper.map(listliendoc,listType);
		return ResponseEntity.status(HttpStatus.OK).body(listliendocdtos);
	}
	@GetMapping("/api/AssociationDarna")
	public Object getAllAssociationDarna()
	{
		List <Document> listliendoc = liendocService.getAllAssociationDarna();
		Type listType = new TypeToken<List<DocumentDto>>() {}.getType();
		List<DocumentDto> listliendocdtos = modelMapper.map(listliendoc,listType);
		return ResponseEntity.status(HttpStatus.OK).body(listliendocdtos);
	}

}
