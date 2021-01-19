package com.darna.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.darna.models.Notification;
import com.darna.repository.NotificationRepository;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@EnableAutoConfiguration
public class NotificationRepositoryTest {

	@Autowired 
	private NotificationRepository notifRepository;
	
	@Test
	@Rollback(false)
	public void getNotificationAdmin() {
		
		List<Notification> listnotifs=(List<Notification>) notifRepository.findNotificationAdmin();
		assertThat(listnotifs.size()).isGreaterThan(0);
		assertNotNull(listnotifs);
	}
	@Test
	@Rollback(false)
	public void getNotificationMembre() {
		
		List<Notification> listnotifs=(List<Notification>) notifRepository.findNotificationMembre();
		assertThat(listnotifs.size()).isGreaterThan(0);
		assertNotNull(listnotifs);
	}
	@Test
	@Rollback(false)
	public void countNotificationMembre() {
		
		long countnotif= notifRepository.CountNotificationMembre();
		assertThat(countnotif).isGreaterThan(0);
		assertNotNull(countnotif);
	}
	@Test
	@Rollback(false)
	public void countNotificationAdmin() {
		
		long countnotif= notifRepository.CountNotificationAdmin();
		assertThat(countnotif).isGreaterThan(0);
		assertNotNull(countnotif);
	}
}
