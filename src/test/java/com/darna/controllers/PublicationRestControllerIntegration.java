package com.darna.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import com.darna.models.Publication;
import com.darna.repository.PublicationRepository;
import com.darna.services.PublicationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.NONE)
@EnableAutoConfiguration
public class PublicationRestControllerIntegration {

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
	@InjectMocks
	PublicationController publicationController;
	
	 @Before
	    public void setup() throws Exception {
	        this.mockMvc = standaloneSetup(publicationController).build();
	    }
	
	@Test
	public void TestaddPublication() throws JsonProcessingException,Exception {
		
		Publication newpublication= new Publication(17,"Faire un don","http://www.donbyuib.com.tn","Aidez les enfants depuis ce lien");
		String url="/api/publication";
		MvcResult mvcResult=mockMvc.perform(post(url)
	    		.contentType("application/json")
	    		.content(objectMapper.writeValueAsString(newpublication))
	    		.with(csrf())
	    		)
	    		.andExpect(status().isOk())
	    		.andDo(print())
	    		.andReturn();
		/*String response=mvcResult.getResponse().getContentAsString();
		Publication publication=objectMapper.readValue(response,Publication.class);
		//Publication publication=publicationService.getPublicationById(17);
		assertThat(publication).isEqualTo(newpublication);*/
	}

	@Test
	public void TestDeletePublication() throws Exception {
		Long idPublication=(long) 15;
		String url="/api/deletepublication/"+idPublication;
		mockMvc.perform(delete(url))
	    		.andExpect(status().isNoContent())
	    		.andDo(print())
	    		.andReturn();
		Publication result=publicationService.getPublicationById(idPublication);
		assertThat(result).isNull();;		
	}
	@Test
	@DisplayName("Should return list of publication")
	public void TestListPublication() throws JsonProcessingException,Exception {
		MvcResult mvcResult=mockMvc.perform(get("/api/listpublication")
				  .contentType("application/json")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
				  .andDo(print())
				  .andReturn();
				
		String jsonResponse=mvcResult.getResponse().getContentAsString();
		Publication[] listpublication=objectMapper.readValue(jsonResponse,Publication[].class);
		assertThat(listpublication).hasSize(0);

		
	}
	
	
	@Test
	@DisplayName("Should return publication By Id")
	public void TestgetPublicationById() throws Exception 
	{
		Publication publication = new Publication(12,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don");
		MvcResult mvcResult= mockMvc.perform(get("/api/Publication/{idPub}", 12)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
		  .andDo(print())
		  .andReturn();
		/*String jsonResponse=mvcResult.getResponse().getContentAsString();
		Publication cpublication=objectMapper.readValue(jsonResponse,Publication.class);
		assertThat(publication).isEqualTo(cpublication);*/
	    
	}
	
}
