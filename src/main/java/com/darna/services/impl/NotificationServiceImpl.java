package com.darna.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.Notification;
import com.darna.repository.NotificationRepository;
import com.darna.services.NotificationService;

@Service
public class NotificationServiceImpl  implements NotificationService {
	
	@Autowired 
	private NotificationRepository notificationRepository;

	@Transactional
	@Override
	public Notification addNotification(Notification notif) {
		return notificationRepository.save(notif);
	}
	@Transactional
	@Override
	public Notification consulterNotification(long idnotif) {
		Notification notif=notificationRepository.findById(idnotif).get();
		notif.setConsulter(true);
		return notif;
	}

	@Transactional
	@Override
	public void deleteNotification(long idnotif) {
		notificationRepository.deleteById(idnotif);
	}
	@Transactional
	@Override
	public List<Notification> getAllNotificationAdmin() {
		
		return notificationRepository.findNotificationAdmin();
	}
	@Transactional
	@Override
	public List<Notification> getAllNotificationMembre() {
		return notificationRepository.findNotificationMembre();
	}
	@Transactional
	@Override
	public long countNotificationAdmin() {
		return notificationRepository.CountNotificationAdmin();
	}
	@Transactional
	@Override
	public long countNotificationMembre() {
		return notificationRepository.CountNotificationMembre();
	}

}
