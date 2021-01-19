package com.darna.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.darna.models.Objectif;
import com.darna.repository.ObjectifRepository;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@EnableAutoConfiguration
public class ObjectifRepositoryTest {

	@Autowired 
	private ObjectifRepository objectifRepository;
	
	@Test
	@Rollback(false)
	public void addObjectif() {
		
		Objectif objectif=new Objectif();
		objectif.setDescription_objectif("Prise en charge d’enfants sans soutien familial");
		Objectif savedobjectif=objectifRepository.save(objectif);
		assertThat(savedobjectif).isNotNull();
	}
	@Test
	@Rollback(false)
	public void updateObjectif() {
		
		long idoldObjectif=3;
		
		Objectif objectif=new Objectif();
		objectif.setDescription_objectif("Création d’un cadre familial stable avec des unités de vie");
		
		objectif.setIdObjectif(idoldObjectif);
		
		Objectif updatedobjectif=objectifRepository.save(objectif);
		
		assertThat(updatedobjectif.getDescription_objectif()).isEqualTo(objectif.getDescription_objectif());
		
	}
	@Test
	@Rollback(false)
	public void getAllObjectif() {
		List<Objectif> listobjs=(List<Objectif>) objectifRepository.findAll();
		assertThat(listobjs.size()).isGreaterThan(0);
		assertNotNull(listobjs);
	}
	@Test
	@Rollback(false)
	public void getObjectifById() {
		long idobj=5;
		Objectif objectif=objectifRepository.findById(idobj).get();
		assertNotNull(objectif);
		assertThat(objectif.getDescription_objectif()).isEqualTo("Création d’un cadre familial stable avec des unités de vie");
	}
	@Test
	@Rollback(false)
	public void deleteObjectifById() {
		long idobj=2;
		objectifRepository.deleteById(idobj);
		Optional<Objectif> objectif=objectifRepository.findById(idobj);
		assertThat(objectif).isEmpty();
		
	}
}
