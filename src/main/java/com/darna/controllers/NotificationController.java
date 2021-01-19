package com.darna.controllers;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.darna.models.Notification;
import com.darna.services.NotificationService;

@CrossOrigin("*")
@RestController()
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/api/listNotificationAdmin")
	public Object getAllNotificationAdmin()
	{
		List <Notification> listaction = notificationService.getAllNotificationAdmin();
		return ResponseEntity.status(HttpStatus.OK).body(listaction);
	}
	@GetMapping("/api/listNotificationMembre")
	public Object getAllNotificationMembre()
	{
		List <Notification> listaction = notificationService.getAllNotificationMembre();
		return ResponseEntity.status(HttpStatus.OK).body(listaction);
	}

	@DeleteMapping("/api/deleteNotification/{idN}")
    public Object deleteNotification(@PathVariable("idN")Long idNotif )
    {
		notificationService.deleteNotification(idNotif);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
	@PostMapping("/api/consulternotif/{idN}")
	public Object ConsulterNotifications(@PathVariable("idN") long idN) 
	{
		notificationService.consulterNotification(idN);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	@GetMapping("/api/notificationsMembreCount")
	public Object CountNotificationsMembre() 
	{
		long nbrnotification= notificationService.countNotificationMembre();
		return nbrnotification;
	}
	@GetMapping("/api/notificationsAdminCount")
	public Object CountNotificationsAdmin() 
	{
		long nbrnotification= notificationService.countNotificationAdmin();
		return nbrnotification;
	}
}
