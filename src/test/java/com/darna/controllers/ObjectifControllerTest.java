package com.darna.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.darna.models.Objectif;
import com.darna.repository.ObjectifRepository;
import com.darna.services.ObjectifService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ObjectifController.class, ObjectifService.class})
@WebMvcTest(excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class ObjectifControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
 
	@MockBean
	private ObjectifService objectifService;
	@MockBean
	private ObjectifRepository objectifRepo;
	
	@MockBean
	ModelMapper modelMapper;
	
	@Test
	@DisplayName("Should return list of objectif")
	public void TestgetAllObjectif() throws JsonProcessingException,Exception {
		
		List<Objectif> listobjectif=new ArrayList<>();
		listobjectif.add(new Objectif(1,"Prise en charge d enfants sans soutien familial"));
		listobjectif.add(new Objectif(2,"Apport moral, educatif et financier pour ces enfants"));
		listobjectif.add(new Objectif(3,"Creation d un cadre familial stable avec des unites de vie"));
		listobjectif.add(new Objectif(4,"Integration sociale a long terme"));
		listobjectif.add(new Objectif(5,"Sensibiliser d autres partenaires a la creation d autres unites de vie similaire"));

		Mockito.when(objectifService.getAllObjectif()).thenReturn(listobjectif);
		
		String url="/api/listObjectif";
		
		MvcResult mvcResult=mockMvc.perform(get(url))
	    		.andExpect(status().isOk())
	    		.andDo(print())
	    		.andReturn();
		
		String actualJsonResponse=mvcResult.getResponse().getContentAsString();		
	    String expectedJsonResponse=objectMapper.writeValueAsString(listobjectif);
	    assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
	   
	}
	@Test
	@DisplayName("Should delete an objectif")
	public void TestdeleteObjectif() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders.delete("/api/deleteObjectif/{idO}", 7) )
		        .andExpect(status().isNoContent());
		        
	}
	@Test
	@DisplayName("Should return objectif By id")
	public void TestgetObjectifById() throws Exception 
	{
		 Objectif objectif = new Objectif(1,"Prise en charge d enfants sans soutien familial");
         
		 Mockito.when(objectifService.getObjectifById(1)).thenReturn(objectif);
		 
		 mockMvc.perform(get("/api/Objectif/{idO}", 1)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
		  .andDo(print())
	      .andExpect(jsonPath("$.idObjectif", is(1)))
	      .andExpect(jsonPath("$.description_objectif", is("Prise en charge d enfants sans soutien familial")));
	}
}
