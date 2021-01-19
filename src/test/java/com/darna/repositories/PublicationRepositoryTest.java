package com.darna.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import com.darna.models.Publication;
import com.darna.repository.PublicationRepository;


@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@EnableAutoConfiguration
public class PublicationRepositoryTest {
	
	@Autowired 
	private PublicationRepository publicationRepostiory;
	
	@Test
	@Rollback(false)
	public void addPublication() {
		
		Publication publication=new Publication();
		publication.setType_publication("Faire un don");
		publication.setDescription_publication("En faisant un don, vous aidez de maniere simple des enfants sans soutien familial.Voici notre RIB: 08601000191000748054 (Agence BIAT Charguia 2).");
		publication.setLien_publication("http://www.donbyuib.com.tn/darna.html");
		Publication savedpublication=publicationRepostiory.save(publication);
		assertThat(savedpublication).isNotNull();
		

	}
	@Test
	@Rollback(false)
	public void updatePublication() {
		
		long idoldpub=22;
		
		Publication publication=new Publication();
		publication.setType_publication("إعلام");
		publication.setDescription_publication("باعلام الرأي العام بأنه تم تنقيح النظام الأساسي للجمعية إثر مداولات الجلسة العامة الخارقة للعادة التي إنعقدت بتاريخ 10 مارس 2017 بمقرها الكائن بالشرقية 2.");
		publication.setLien_publication("");
		
		publication.setId_Publication(idoldpub);
		
		Publication updatedpub=publicationRepostiory.save(publication);
		
		assertThat(updatedpub.getType_publication()).isEqualTo(publication.getType_publication());
		assertThat(updatedpub.getDescription_publication()).isEqualTo(publication.getDescription_publication());
		assertThat(updatedpub.getLien_publication()).isEqualTo(publication.getLien_publication());


	}
	@Test
	@Rollback(false)
	public void getAllPublication() {
		
		List<Publication> listpubs=(List<Publication>) publicationRepostiory.findAll();
		assertThat(listpubs.size()).isGreaterThan(0);
		assertNotNull(listpubs);


	}
	@Test
	@Rollback(false)
	public void getPublicationById() {
		long idoldpub=22;
		Publication pub=publicationRepostiory.findById(idoldpub).get();
		assertNotNull(pub);
		assertThat(pub.getType_publication()).isEqualTo("إعلام");
		assertThat(pub.getDescription_publication()).isEqualTo("باعلام الرأي العام بأنه تم تنقيح النظام الأساسي للجمعية إثر مداولات الجلسة العامة الخارقة للعادة التي إنعقدت بتاريخ 10 مارس 2017 بمقرها الكائن بالشرقية 2.");
		assertThat(pub.getLien_publication()).isEqualTo("");
	}
	@Test
	@Rollback(false)
	public void deletePublicationById() {
		long idpub=31;
		publicationRepostiory.deleteById(idpub);
		Optional<Publication> pub=publicationRepostiory.findById(idpub);
		assertThat(pub).isEmpty();
		
	}

}
