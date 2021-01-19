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

import com.darna.models.Publication;
import com.darna.repository.PublicationRepository;
import com.darna.services.impl.PublicationServiceImpl;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class PublicationServiceTest {
	
	@MockBean
	private PublicationRepository publicationRepo;
	@InjectMocks
	private PublicationServiceImpl publicationService;
	
	
	@Test
	public void addPublication() {
		Publication publication=new Publication(18,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don, vous aidez de maniere simple des enfants sans soutien familial.Voici notre RIB: 08601000191000748054 (Agence BIAT Charguia 2).");
		Mockito.when(publicationRepo.save(publication)).thenReturn(publication);
		
		Publication savedpublication=publicationService.addPublication(publication);
		
		assertThat(savedpublication).isEqualTo(publication);
		
	}
	@Test
	public void updatePublication() {
		Publication oldpublication=new Publication(18,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don, vous aidez de maniere simple des enfants sans soutien familial.Voici notre RIB: 08601000191000748054 (Agence BIAT Charguia 2).");
		Publication newpublication=new Publication(19,"Faire un don 1","http://www.donbyuib.com.tn/darna.html","En faisant un don, vous aidez de maniere simple des enfants sans soutien familial.Voici notre RIB: 08601000191000748054 (Agence BIAT Charguia 2).");
		
		Mockito.when(publicationRepo.save(newpublication)).thenReturn(newpublication);
		
		Publication savedpublication=publicationService.updatePublication(newpublication, oldpublication.getId_Publication());
		
		assertThat(savedpublication).isEqualTo(newpublication);
		
	}
	
	@Test
	public void getAllPublication() {
		
		List<Publication> listpublication=new ArrayList<>();
		listpublication.add(new Publication(3,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don, vous aidez de maniere simple des enfants sans soutien familial.Voici notre RIB: 08601000191000748054 (Agence BIAT Charguia 2)."));
		listpublication.add(new Publication(12,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don, vous aidez de maniere simple des enfants sans soutien familial.Voici notre RIB: 08601000191000748054 (Agence BIAT Charguia 2)."));
		listpublication.add(new Publication(15,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don, vous aidez de maniere simple des enfants sans soutien familial.Voici notre RIB: 08601000191000748054 (Agence BIAT Charguia 2)."));
		listpublication.add(new Publication(16,"Faire un don","http://www.donbyuib.com.tn/darna.html","En faisant un don, vous aidez de maniere simple des enfants sans soutien familial.Voici notre RIB: 08601000191000748054 (Agence BIAT Charguia 2)."));

		Mockito.when(publicationRepo.findAll()).thenReturn(listpublication);
		List<Publication> listpubs=publicationService.getAllPublication();
		assertThat(listpublication).isEqualTo(listpubs);
		
	}
	
}
