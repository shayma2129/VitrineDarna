package com.darna.controllers;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.darna.models.Action;
import com.darna.services.ActionService;
import com.darna.services.NotificationService;
import com.darna.services.UserCommentaireActionService;
import com.darna.services.UserParticiperActionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ActionController.class, ActionService.class})
@WebMvcTest(excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class ActionRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ModelMapper modelMapper;
	@MockBean
	private ActionService actionService;
	@MockBean
	private UserParticiperActionService userParticiperActionService;
	@MockBean
	private UserCommentaireActionService userCommentaireActionService;
	@MockBean
	private NotificationService notificationService;
	@Autowired
	private ObjectMapper objectMapper;
	
	 @Test
	 @DisplayName("Should upload with success")
	 public void testUpload_addAction() throws Exception {
		long now=System.currentTimeMillis();
		Calendar c = Calendar.getInstance();
		Action action =new Action(3, "nom", "des","lieu",new Date(), new Date(),c,c, false,(long)9);
		byte[] imagebyte = Files.readAllBytes(Paths.get("C:\\wamp64\\www\\darna_app\\actions\\test.png"));
        MockMultipartFile file = new MockMultipartFile("photo", "test.jpeg", "image/jpeg", imagebyte);
        Mockito.when(actionService.addAction(action)).thenReturn(action);
	       mockMvc.perform(
	                multipart("/api/saveaction")
	                        .file(file)
	                        .param("data",objectMapper.writeValueAsString(action))
	                        .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andDo(print())
	                .andExpect(jsonPath("$.path_photo", is("Photo_nom_"+now+".png")))
	                .andExpect(content().string("Photo_nom_"+now+".png"));
	      
	    }
	 @Test
	 @DisplayName("Should post the action")
	 public void TestPublierAction() throws Exception 
		{
		    Action action =new Action(3, "conference de presse", "des","lieu",new Date(), new Date(),null,null, true,(long)9);
		    
			Mockito.when(actionService.publierAction((long) 3,true)).thenReturn(action);
			 
			 mockMvc.perform(
				put("/api/publieraction/{idA}", 3)
		             .accept(MediaType.APPLICATION_JSON))
		             .andExpect(status().isOk())
			         .andDo(print())
		      .andExpect(jsonPath("$.id_Action", is(3)))
		      .andExpect(jsonPath("$.nom_action", is("conference de presse")))
		      .andExpect(jsonPath("$.etat_action", is(true)));
		}
}
