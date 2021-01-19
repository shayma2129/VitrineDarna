package com.darna.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.darna.models.Action;
import com.darna.models.Notification;
import com.darna.repository.NotificationRepository;
import com.darna.services.NotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {NotificationController.class, NotificationService.class})
@WebMvcTest(excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class NotificationRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
 
	@MockBean
	private NotificationService notifService;
	@MockBean
	private NotificationRepository notifRepo;
	
	@MockBean
	ModelMapper modelMapper;

	@Test
	@DisplayName("Should return list notification of admin")
	public void TestgetAllNotificationAdmin() throws JsonProcessingException,Exception {
		
		Action action=new Action();
		List<Notification> listnotifs=new ArrayList<>();
		listnotifs.add(new Notification("Le nombre des membres n'est pas atteint",action));
		listnotifs.add(new Notification("Le nombre des membres n'est pas atteint",action));
		listnotifs.add(new Notification("Le nombre des membres n'est pas atteint",action));

		Mockito.when(notifService.getAllNotificationAdmin()).thenReturn(listnotifs);
		
		String url="/api/listNotificationAdmin";
		
		MvcResult mvcResult=mockMvc.perform(get(url))
	    		.andExpect(status().isOk())
	    		.andDo(print())
	    		.andReturn();
		
		String actualJsonResponse=mvcResult.getResponse().getContentAsString();		
	    String expectedJsonResponse=objectMapper.writeValueAsString(listnotifs);
	    assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
	   
	}
	@Test
	@DisplayName("Should return list notification of membre")
	public void TestgetAllNotificationMembre() throws JsonProcessingException,Exception {
		
		List<Notification> listnotifs=new ArrayList<>();
		listnotifs.add(new Notification(16,"Une nouvelle action a ete ajoute",false));
		listnotifs.add(new Notification(17,"Une nouvelle action a ete ajoute",true));
		listnotifs.add(new Notification(18,"Une nouvelle action a ete ajoute",false));

		Mockito.when(notifService.getAllNotificationMembre()).thenReturn(listnotifs);
		
		String url="/api/listNotificationMembre";
		
		MvcResult mvcResult=mockMvc.perform(get(url))
	    		.andExpect(status().isOk())
	    		.andDo(print())
	    		.andReturn();
		
		String actualJsonResponse=mvcResult.getResponse().getContentAsString();		
	    String expectedJsonResponse=objectMapper.writeValueAsString(listnotifs);
	    assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
	   
	}
	
	@Test
	@DisplayName("Should return the number of notif membre")
	public void TestCountNotificationMembre() throws JsonProcessingException,Exception {
		
		List<Notification> listnotifs=new ArrayList<>();
		listnotifs.add(new Notification(16,"Une nouvelle action a ete ajoute",false));
		listnotifs.add(new Notification(17,"Une nouvelle action a ete ajoute",true));
		listnotifs.add(new Notification(18,"Une nouvelle action a ete ajoute",false));

		long nbnotifs=listnotifs.size();
		Mockito.when(notifService.countNotificationMembre()).thenReturn(nbnotifs);
		
		String url="/api/notificationsMembreCount";
		
		MvcResult mvcResult=mockMvc.perform(get(url))
	    		.andExpect(status().isOk())
	    		.andDo(print())
	    		.andReturn();
		
		String actualJsonResponse=mvcResult.getResponse().getContentAsString();		
	    String expectedJsonResponse=objectMapper.writeValueAsString(nbnotifs);
	    assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
	   
	}
	@Test
	@DisplayName("Should return the number of notif admin")
	public void TestCountNotificationAdmin() throws JsonProcessingException,Exception {
		
		Action action=new Action();
		List<Notification> listnotifs=new ArrayList<>();
		listnotifs.add(new Notification("Le nombre des membres n'est pas atteint",action));
		listnotifs.add(new Notification("Le nombre des membres n'est pas atteint",action));
		listnotifs.add(new Notification("Le nombre des membres n'est pas atteint",action));

		long nbnotifs=listnotifs.size();
		Mockito.when(notifService.countNotificationAdmin()).thenReturn(nbnotifs);
		
		String url="/api/notificationsAdminCount";
		
		MvcResult mvcResult=mockMvc.perform(get(url))
	    		.andExpect(status().isOk())
	    		.andDo(print())
	    		.andReturn();
		
		String actualJsonResponse=mvcResult.getResponse().getContentAsString();		
	    String expectedJsonResponse=objectMapper.writeValueAsString(nbnotifs);
	    assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
	   
	}
}
