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
import com.darna.dto.SlideDto;
import com.darna.models.Document;
import com.darna.models.Slide;
import com.darna.services.DocumentService;
import com.darna.services.SlideService;
import com.fasterxml.jackson.databind.JsonMappingException;

@CrossOrigin("*")
@RestController()
public class SlideController {
	
	@Autowired
	private SlideService slideService;
	@Autowired
	private DocumentService documentService;
	@Autowired
	ModelMapper modelMapper;
	
	private static String UPLOAD_DIR ="C:\\wamp64\\www\\darna_app\\documents\\slide";
	String filePath = "C:\\wamp64\\www\\darna_app\\documents\\Slide\\defaultslide.jpg";


	@PostMapping("/api/slide")
	public Object saveSlide(@RequestParam("file[]") MultipartFile[] file)throws Exception,IOException,JsonParseException , JsonMappingException {
		Slide slide=new Slide();
		Slide slideBD=slideService.addSlide(slide);
		
	    	 for(int i=0;i<file.length;i++) {
				   Document document = new Document();
		           document.setFile(file[i].getBytes());
			       String filename= file[i].getOriginalFilename();
			       String modifiedFileName=FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
			       document.setPath_doc(modifiedFileName);
			       Path rootLocation = Paths.get(UPLOAD_DIR);
			       Files.copy(file[i].getInputStream(), rootLocation.resolve(modifiedFileName));
			       document.setSlide(slide);
			       documentService.addDocument(document);
			   }
	       
	       SlideDto slideDto=modelMapper.map(slideBD,SlideDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(slideDto);
	}
	
	@PutMapping("/api/oldslide/{idS}")
	public Object updateSlide(@RequestParam("file[]") MultipartFile[] file,@PathVariable("idS") Long idS)throws Exception,IOException,JsonParseException , JsonMappingException {
		Slide slide=slideService.getSlide(idS);
	
	    	 documentService.deleteAllSlide(idS);
	    	 for(int i=0;i<file.length;i++) {
				   Document document = new Document();
		           document.setFile(file[i].getBytes());
			       String filename= file[i].getOriginalFilename();
			       String modifiedFileName=FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
			       document.setPath_doc(modifiedFileName);
			       Path rootLocation = Paths.get(UPLOAD_DIR);
			       Files.copy(file[i].getInputStream(), rootLocation.resolve(modifiedFileName));
			       document.setSlide(slide);
			       documentService.addDocument(document);
			   }
	         
	       SlideDto slideDto=modelMapper.map(slide,SlideDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(slideDto);
	}

	@DeleteMapping("/api/deleteSlide/{idS}")
    public Object deleteSlide(@PathVariable("idS")Long idS )
    {
		slideService.deleteAllSlide(idS);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
	@GetMapping("/api/Slide/{idS}")
	public Object getSlideById(@PathVariable("idS") Long idS)
    {
		Slide slide=slideService.getSlide(idS);
		SlideDto slideDto=modelMapper.map(slide,SlideDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(slideDto);
    }
	@GetMapping("/api/imageSlide/{idS}")
	public Object getAllImageSlide(@PathVariable("idS") Long idS)
	{
		List <Document> listdoc = slideService.getAllImageSlide(idS);
		Type listType = new TypeToken<List<DocumentDto>>() {}.getType();
		List<DocumentDto> listdocdtos = modelMapper.map(listdoc,listType);
		return ResponseEntity.status(HttpStatus.OK).body(listdocdtos);
	}

}
