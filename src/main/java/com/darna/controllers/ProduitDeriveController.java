package com.darna.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.darna.dto.ProduitDeriveDto;
import com.darna.models.ProduitDerive;
import com.darna.response.MessageResponse;
import com.darna.services.ProduitDeriveService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ProduitDerive")
public class ProduitDeriveController {
	
	@Autowired
	 ProduitDeriveService produitDeriveService ;
	@Autowired
	ModelMapper modelMapper;
	private static String UPLOAD_DIR ="C:\\wamp64\\www\\imageDarna";

	
	
	@PostMapping("/save")
	public Object saveProduit(@Valid @RequestBody ProduitDeriveDto produitDeriveDto) {
		ProduitDerive produitDerive=modelMapper.map(produitDeriveDto, ProduitDerive.class);
		produitDerive =produitDeriveService.addProduitDerive(produitDerive);
		produitDeriveDto =modelMapper.map(produitDerive, ProduitDeriveDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(produitDeriveDto);
	}
	
	
	   
     @PostMapping("/saveProduit")
	public ResponseEntity<MessageResponse> saveDocumentFile( @RequestParam("file[]") List<MultipartFile> files,@RequestParam("data") String DesExp,HttpServletRequest request) throws IOException,JsonParseException , JsonMappingException{
    	   ResponseEntity<MessageResponse>    response = new ResponseEntity<MessageResponse>(new MessageResponse("bad request"),HttpStatus.BAD_REQUEST);
    	 for(MultipartFile file: files) {
    		 ProduitDerive ProduitDerive =new ObjectMapper().readValue(DesExp, ProduitDerive.class);
    		 ProduitDerive.setFile(file.getBytes());
    				
//    		
    		       String filename= file.getOriginalFilename();
    		       String modifiedFileName=FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
    		       ProduitDerive.setPath(  modifiedFileName);
    		       Path rootLocation = Paths.get(UPLOAD_DIR);
    		       Files.copy(file.getInputStream(), rootLocation.resolve(modifiedFileName));
    		       ProduitDerive =produitDeriveService.addProduitDerive(ProduitDerive);
    		      
    		       if(ProduitDerive!=null)
    		       {
    		   		//designExperienceDto =modelMapper.map(designExperience, DesignExperienceDto.class);
    		   		response = new ResponseEntity<MessageResponse>(new MessageResponse("Image is saved successfully"),HttpStatus.OK);
    		       }
    		       else {
    		   		response = new ResponseEntity<MessageResponse>(new MessageResponse("Image is not saved"),HttpStatus.BAD_REQUEST);

    		       }	
    		}
    		return response;
    	 
		 
			
		} 
     
 	
 	@GetMapping(value = "/listProduits")
 	public List<ProduitDerive> findAll() {
 		return produitDeriveService.findAllProduitDerive();
 	}
 	
   @GetMapping(value ="/element/{id}")
   public ProduitDerive findbyidElement(@PathVariable("id") long id) {
 		return produitDeriveService.findbyid(id);

 	}

	   
	@DeleteMapping("/elementDelete/{id}")
    public Object deleteElement(@PathVariable("id")Long id )
    {
		produitDeriveService.deleteProduitDerive(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
	
	


	@PutMapping("update/{id}")
	public ResponseEntity<MessageResponse>  Updateupload( @RequestParam("file[]") List<MultipartFile> files,@RequestParam("data") String DesExp,HttpServletRequest request,@PathVariable("id") Long id) {
		   ResponseEntity<MessageResponse>  response = new ResponseEntity<MessageResponse>(new MessageResponse("Image is not saved"),HttpStatus.BAD_REQUEST);

		for(MultipartFile file: files) {	
		try {
			ProduitDerive produitDerive=produitDeriveService.findbyid(id);
			produitDeriveService.updateProduitDerive(id,produitDerive);
			String fileName = file.getOriginalFilename();
		
			  String modifiedFileName=FilenameUtils.getBaseName(fileName)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(fileName);
			  produitDerive.setPath(  modifiedFileName);
		       Path rootLocation = Paths.get(UPLOAD_DIR);

		       Files.copy(file.getInputStream(), rootLocation.resolve(modifiedFileName));
			
				String path = request.getServletContext().getRealPath("") + UPLOAD_DIR ;

				produitDeriveService.addProduitDerive(produitDerive);
				produitDeriveService.saveFile(file.getInputStream(), path);
		 
	
   		response = new ResponseEntity<MessageResponse>(new MessageResponse("Image is saved successfully"),HttpStatus.OK);
			
		} catch (Exception e) {
	   		response = new ResponseEntity<MessageResponse>(new MessageResponse("Image is not saved "),HttpStatus.OK);
		}
	
		
	}	
		return response;

    
}

   
}
