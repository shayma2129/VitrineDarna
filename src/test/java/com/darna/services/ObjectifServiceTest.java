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
import com.darna.models.Objectif;
import com.darna.repository.ObjectifRepository;
import com.darna.services.impl.ObjectifServiceImpl;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class ObjectifServiceTest {
	
	@MockBean
	private ObjectifRepository objectifRepo;
	@InjectMocks
	private ObjectifServiceImpl objectifService;

	@Test
	public void addObjectif() {
		Objectif objectif=new Objectif(18,"Intégration sociale à long terme");
		
		Mockito.when(objectifRepo.save(objectif)).thenReturn(objectif);
		
		Objectif savedobj=objectifService.addObjectif(objectif);
		
		assertThat(savedobj).isEqualTo(objectif);
		
	}
	@Test
	public void updateObjectif() {
		Objectif oldObjectif=new Objectif(18,"Intégration sociale à long terme");
		Objectif newobjectif=new Objectif(19,"Sensibiliser d’autres partenaires à la création d’autres unités de vie similaire");
		
		Mockito.when(objectifRepo.save(newobjectif)).thenReturn(newobjectif);
		
		Objectif savedobj=objectifService.updateObjectif(newobjectif, oldObjectif.getIdObjectif());
		
		assertThat(savedobj).isEqualTo(newobjectif);
		
	}
	
	@Test
	public void getAllObjectif() {
		
		List<Objectif> listobjectif=new ArrayList<>();
		listobjectif.add(new Objectif(1,"Prise en charge d’enfants sans soutien familial"));
		listobjectif.add(new Objectif(2,"Apport moral, éducatif et financier pour ces enfants"));
		listobjectif.add(new Objectif(3,"Création d’un cadre familial stable avec des unités de vie"));
		listobjectif.add(new Objectif(4,"Intégration sociale à long terme"));
		listobjectif.add(new Objectif(5,"Sensibiliser d’autres partenaires à la création d’autres unités de vie similaire"));

		Mockito.when(objectifRepo.findAll()).thenReturn(listobjectif);
		List<Objectif> listobjs=objectifService.getAllObjectif();
		assertThat(listobjectif).isEqualTo(listobjs);
		
	}
}
