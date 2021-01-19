package com.darna.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.darna.models.Publication;
import com.darna.repository.PublicationRepository;
import com.darna.services.PublicationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PublicationController.class, PublicationService.class})
@WebMvcTest(excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class PublicationRestControllerTest {
	
	

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
 
	@MockBean
	private PublicationService publicationService;
	@MockBean
	private PublicationRepository publicationRepo;
	
	@MockBean
	ModelMapper modelMapper;
	
	
	
	@Test
	@DisplayName("S:1 - Should return list of publication")
	public void TestgetAllPublication() throws JsonProcessingException,Exception {
		
		List<Publication> listpublication=new ArrayList<>();
		listpublication.add(new Publication(3,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don, vous aidez de maniere simple des enfants sans soutien familial.Voici notre RIB: 08601000191000748054 (Agence BIAT Charguia 2)."));
		listpublication.add(new Publication(12,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don, vous aidez de maniere simple des enfants sans soutien familial.Voici notre RIB: 08601000191000748054 (Agence BIAT Charguia 2)."));
		listpublication.add(new Publication(15,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don, vous aidez de maniere simple des enfants sans soutien familial.Voici notre RIB: 08601000191000748054 (Agence BIAT Charguia 2)."));

		Mockito.when(publicationService.getAllPublication()).thenReturn(listpublication);
		
		String url="/api/listpublication";
		
		MvcResult mvcResult=mockMvc.perform(get(url))
	    		.andExpect(status().isOk())
	    		.andDo(print())
	    		.andReturn();
		
		String actualJsonResponse=mvcResult.getResponse().getContentAsString();		
	    String expectedJsonResponse=objectMapper.writeValueAsString(listpublication);
	    assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
	   
	}
	@Test
	@DisplayName("S:2 - Should return list of publication")
	public void TestgetListPublication()
	  throws Exception {
	    
	    Publication publication = new Publication(1,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don");

	    List<Publication> allPublication = Arrays.asList(publication);

	    Mockito.when(publicationService.getAllPublication()).thenReturn(allPublication);

	    mockMvc.perform(get("/api/listpublication")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andDo(print())
	      .andExpect(jsonPath("$.size()", is(1)))
	      .andExpect(jsonPath("$[0].id_Publication", is(1)));
	}
	

	@Test
	@DisplayName("Should add a publication")
	public void TestaddPublication()
	  throws JsonProcessingException, Exception {
	    
	    Publication publication = new Publication(16,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don");
	    Publication savedpublication=new Publication(16,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don");

	    Mockito.when(publicationService.addPublication(publication)).thenReturn(savedpublication);

	    mockMvc.perform(post("/api/publication")
	      .contentType(MediaType.APPLICATION_JSON)
	      .content(objectMapper.writeValueAsString(publication))
	      .with(csrf()))
	      .andExpect(status().isOk())
	      .andDo(print());
	      //.andExpect(jsonPath("$.id_Publication", is(16)))
	      //.andExpect(jsonPath("$.type_publication",is("Faire un don")));
	     
	    
	}
	@Test
	@DisplayName("Should update a publication")
	public void TestupdatePublication()
	  throws JsonProcessingException, Exception {
	    
	    Publication oldpublication = new Publication(1,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don");
	    Publication savedpublication=new Publication(1,"Faire un don update","http://www.donbyuib.com.tn/darna.html","En faisant un don");

	    Mockito.when(publicationService.updatePublication(savedpublication, oldpublication.getId_Publication())).thenReturn(savedpublication);

	    mockMvc.perform(put("/api/oldpublication/{idPub}",1)
	      .contentType(MediaType.APPLICATION_JSON)
	      .content(objectMapper.writeValueAsString(savedpublication))
	      .with(csrf()))
	      .andExpect(status().isOk())
	      .andDo(print());
	      //.andExpect(jsonPath("$.id_Publication", is(1)))
	      //.andExpect(jsonPath("$.type_publication",is("Faire un don")));
	     
	    
	}
	
	@Test
	@DisplayName("Should delete a publication")
	public void TestdeletePublication() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders.delete("/api/deletepublication/{idPub}", 12) )
		        .andExpect(status().isNoContent());
		        
	}
	@Test
	@DisplayName("Should return publication By id")
	public void TestgetPublicationById() throws Exception 
	{
		 Publication publication = new Publication(1,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don");
         
		 Mockito.when(publicationService.getPublicationById(1)).thenReturn(publication);
		 
		 mockMvc.perform(get("/api/Publication/{idPub}", 1)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
		  .andDo(print())
	      .andExpect(jsonPath("$.id_Publication", is(1)))
	      .andExpect(jsonPath("$.type_publication", is("Faire un don")))
	      .andExpect(jsonPath("$.lien_publication", is("http://www.donbyuib.com.tn/darna.html")))
	      .andExpect(jsonPath("$.description_publication", is("En faisant un don")));
	}

}
