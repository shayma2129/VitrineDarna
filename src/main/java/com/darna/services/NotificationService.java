package com.darna.services;

import java.util.List;

import com.darna.models.Notification;

public interface NotificationService {
	public Notification addNotification(Notification notif);
	public Notification consulterNotification(long idnotif);
	public void deleteNotification(long idnotif);
	public List<Notification> getAllNotificationAdmin();
	public List<Notification> getAllNotificationMembre();
	public long countNotificationAdmin();
	public long countNotificationMembre();
}
