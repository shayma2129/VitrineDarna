package com.darna.services;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.darna.models.Action;
import com.darna.models.Notification;
import com.darna.repository.NotificationRepository;
import com.darna.services.impl.NotificationServiceImpl;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class NotificationServiceTest {

	@MockBean
	private NotificationRepository notifRepository;
	
	@InjectMocks
	private NotificationServiceImpl notifService;
	
	@Test
	public void addNotification() {
		Notification notif=new Notification();
		notif.setContenu("Test notification");
		notif.setConsulter(false);
		
		Mockito.when(notifRepository.save(notif)).thenReturn(notif);
		Notification savednotif=notifService.addNotification(notif);
	
		assertThat(savednotif).isEqualTo(notif);
		
	}
	@Test
	public void ListNotificationAdmin() {
		Action action=new Action();
		List<Notification> listnotifs=new ArrayList<>();
		listnotifs.add(new Notification("Le nombre des membres n'est pas atteint",action));
		listnotifs.add(new Notification("Le nombre des membres n'est pas atteint",action));
		listnotifs.add(new Notification("Le nombre des membres n'est pas atteint",action));

		Mockito.when(notifRepository.findNotificationAdmin()).thenReturn(listnotifs);
		List<Notification> listnotifications=notifService.getAllNotificationAdmin();
		assertThat(listnotifs).isEqualTo(listnotifications);
		
	}
	@Test
	public void ListNotificationMembre() {
		List<Notification> listnotifs=new ArrayList<>();
		listnotifs.add(new Notification(1,"Test notification",false));
		listnotifs.add(new Notification(2,"Test notification",true));
		listnotifs.add(new Notification(3,"Test notification",false));

		Mockito.when(notifRepository.findNotificationMembre()).thenReturn(listnotifs);
		List<Notification> listnotifications=notifService.getAllNotificationMembre();
		assertThat(listnotifs).isEqualTo(listnotifications);
		
	}
	
	@Test
	public void CountNotificationAdmin() {
		Action action=new Action();
		List<Notification> listnotifs=new ArrayList<>();
		listnotifs.add(new Notification("Le nombre des membres n'est pas atteint",action));
		listnotifs.add(new Notification("Le nombre des membres n'est pas atteint",action));
		listnotifs.add(new Notification("Le nombre des membres n'est pas atteint",action));
		
		long countlist=listnotifs.size();

		Mockito.when(notifRepository.CountNotificationAdmin()).thenReturn(countlist);
		long countlistnotif=notifService.countNotificationAdmin();
		assertThat(countlist).isEqualTo(countlistnotif);
		
	}
	@Test
	public void CountNotificationMembre() {
		List<Notification> listnotifs=new ArrayList<>();
		listnotifs.add(new Notification(1,"Test notification",false));
		listnotifs.add(new Notification(2,"Test notification",true));
		listnotifs.add(new Notification(3,"Test notification",false));

		long countlist=listnotifs.size();
		Mockito.when(notifRepository.CountNotificationMembre()).thenReturn(countlist);
		long countlistnotif=notifService.countNotificationMembre();
		assertThat(countlist).isEqualTo(countlistnotif);
		
	}
	
	
}
