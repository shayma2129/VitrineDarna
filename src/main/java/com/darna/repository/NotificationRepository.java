package com.darna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.darna.models.Notification;


@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
	@Query("SELECT  notif FROM Notification As notif WHERE notif.action.id_Action is not null")
	public List<Notification> findNotificationAdmin();
	@Query("SELECT  notif FROM Notification As notif WHERE notif.action.id_Action is null")
	public List<Notification> findNotificationMembre();
	@Query("SELECT  COUNT(notif) FROM Notification As notif WHERE notif.action.id_Action is null AND notif.consulter=false")
	public long CountNotificationMembre();
	@Query("SELECT  COUNT(notif) FROM Notification As notif WHERE notif.action.id_Action is not null AND notif.consulter=false")
	public long CountNotificationAdmin();

}
