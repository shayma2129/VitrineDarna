package com.darna.controllers;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.darna.dto.ActionDto;
import com.darna.models.Action;
import com.darna.models.Notification;
import com.darna.models.User;
import com.darna.models.UserAction;
import com.darna.models.UserCommentaireAction;
import com.darna.services.ActionService;
import com.darna.services.NotificationService;
import com.darna.services.UserCommentaireActionService;
import com.darna.services.UserParticiperActionService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController()
public class ActionController {
	
	@Autowired
	private ActionService actionService;
	@Autowired
	private UserParticiperActionService userParticiperActionService;
	@Autowired
	private UserCommentaireActionService userCommentaireActionService;
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	ModelMapper modelMapper;
	
    private static String UPLOAD_DIR ="C:\\wamp64\\www\\darna_app\\actions";

	
	/*@PostMapping("/api/saveaction")
	public ResponseEntity<Action> addAction(@RequestParam(name="data",required = false) String data,@RequestParam("photo") MultipartFile photo)throws Exception,IOException,JsonParseException , JsonMappingException  {
		Action action=new ObjectMapper().readValue(data, Action.class);
		String filename= photo.getOriginalFilename();
		String modifiedFileName="Photo_"+action.getNom_action()+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
		action.setPhoto(photo.getBytes());
		action.setPath_photo(modifiedFileName);
	    Path rootLocation = Paths.get(UPLOAD_DIR);
	    Files.copy(photo.getInputStream(), rootLocation.resolve(modifiedFileName));
	    action=actionService.addAction(action);
	    //ActionDto actionDto=modelMapper.map(action,ActionDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(action);
	}*/
	@PostMapping("/api/saveaction")
	public Action addAction(@RequestParam(name="data",required = false) String data,@RequestParam("photo") MultipartFile photo)throws Exception,IOException,JsonParseException , JsonMappingException  {
		Action action=new ObjectMapper().readValue(data, Action.class);
		String filename= photo.getOriginalFilename();
		String modifiedFileName="Photo_"+action.getNom_action()+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
		action.setPhoto(photo.getBytes());
		action.setPath_photo(modifiedFileName);
	    Path rootLocation = Paths.get(UPLOAD_DIR);
	    Files.copy(photo.getInputStream(), rootLocation.resolve(modifiedFileName));
	    action=actionService.addAction(action);
	    //ActionDto actionDto=modelMapper.map(action,ActionDto.class);
		return action;
	}
	@PutMapping("/api/oldAction/{idA}")
	public Object updateAction(@RequestParam(name="data",required = false) String data,@RequestParam("photo") MultipartFile photo,@PathVariable("idA") Long idA)throws Exception,IOException,JsonParseException , JsonMappingException  {
		Action action=new ObjectMapper().readValue(data, Action.class);
		String filename= photo.getOriginalFilename();
		String modifiedFileName="Photo_"+action.getNom_action()+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
		action.setPhoto(photo.getBytes());
		action.setPath_photo(modifiedFileName);
	    Path rootLocation = Paths.get(UPLOAD_DIR);
	    Files.copy(photo.getInputStream(), rootLocation.resolve(modifiedFileName));
	    action=actionService.updateAction(action, idA);
	    ActionDto actionDto=modelMapper.map(action,ActionDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(actionDto);
	}
	
	@GetMapping("/api/listAction")
	public Object getAllAction()
	{
		List <Action> listaction = actionService.getAllAction();
		Type listType = new TypeToken<List<ActionDto>>() {}.getType();
		List<ActionDto> listactiondtos = modelMapper.map(listaction,listType);
		return ResponseEntity.status(HttpStatus.OK).body(listactiondtos);
	}
	@DeleteMapping("/api/deleteAction/{idA}")
    public Object deleteObjectif(@PathVariable("idA")Long idAction )
    {
		actionService.deleteAction(idAction);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
	@GetMapping("/api/Action/{idA}")
	public Object getActionById(@PathVariable("idA") Long idAction)
    {
		Action action=actionService.getActionById(idAction);
		ActionDto actionDto=modelMapper.map(action,ActionDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(actionDto);
    }
	//Houni ekhdemha bel formData w samih champs (etat) lezem ykoun fih true ou false moch 0 ou 1
		@PutMapping("/api/publieraction/{idA}")
		public ResponseEntity<Action> publierAction(@RequestParam(required=false,name="etat") String etat,@PathVariable("idA") Long idA) {
			boolean etat_action=Boolean.parseBoolean(etat);
			Action action=actionService.publierAction(idA,etat_action);
			if(etat_action==true) {
				Notification notif=new Notification("Une nouvelle action a été publier sous le nom "+action.getNom_action());
				notificationService.addNotification(notif);

			}
			return ResponseEntity.status(HttpStatus.OK).body(action);
		}
		
		
	/** Donner l'autorisation à un membre pour participer dans une action **/
	    @PutMapping("/api/autoriser/{idA}/user/{idU}")
		public void autoriserParticipation(@RequestParam(required=false,name="autorisation") String autorisation,@PathVariable("idA") Long idA,@PathVariable("idU") Long idU) {
	    	boolean auto=Boolean.parseBoolean(autorisation);
			userParticiperActionService.autoriserParticipation(idU, idA, auto);
			
		}
	
	///////////////////////participer a une action avec getallactions+getActionByuser+getuserbyaction+detail
	
	@PostMapping("/api/user/{idU}/action/{idA}")
	public void partciperUserAction(@PathVariable("idU") Long idU,@PathVariable("idA") Long idA) {
			
		userParticiperActionService.participerAction(idU, idA);

}
	
	@GetMapping("/api/ActionUser/{idU}/{idA}")
	public UserAction getActionUserById(@PathVariable("idU") Long idU,@PathVariable("idA") Long idA)
    {
		return  userParticiperActionService.getUserActionById(idU, idA);

    }

	
	/** List des actions d'un membre**/
	@GetMapping("/api/findActionByUser/{idU}")
	public Object getActionUserById(@PathVariable("idU") Long idU)
    {
		return  userParticiperActionService.findActionByUser(idU);

    }
	/** List des membres qui sont autorisés pour participer dans une action **/

	@GetMapping("/api/findUserByAction/{idA}")
	public Object getListParticipantByAction(@PathVariable("idA") Long idA)
    {
		return  		userParticiperActionService.findUserByAction(idA);

    }
	/** List demandes des membres qui veut participer dans une action **/
	@GetMapping("/api/listDemande/{idA}")
	public Object getListDemandeParticipationByAction(@PathVariable("idA") Long idA)
	{
		List <User> listDemande = userParticiperActionService.getListDemandeParticipation(idA);
		
		return ResponseEntity.status(HttpStatus.OK).body(listDemande);
	}
	
	
	///////////////////////add commentaire+voir tous les commentaire d'une action
	
	@PostMapping("/api/commentaire/{idU}/{idA}")
	public void addUserComment(@Valid @RequestBody  UserCommentaireAction userCommentaireAction, @PathVariable("idU") Long idU,@PathVariable("idA") Long idA) {
			
		userCommentaireActionService.addCommentaire(idU, idA, userCommentaireAction);
}
	
	@GetMapping("/api/getAllCommentaires/{idA}")
	public Object getAllCommentaireByIdAction(@PathVariable("idA") Long idA)
    {
		return  		userCommentaireActionService.findCommentaireByAction(idA);

    }
	
	
}
