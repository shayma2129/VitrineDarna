package com.darna.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.Publication;
import com.darna.repository.PublicationRepository;
import com.darna.services.PublicationService;

@Service
public class PublicationServiceImpl implements PublicationService {

	@Autowired 
	private PublicationRepository publicationRepostiory;

	@Transactional
	@Override
	public Publication addPublication(Publication publication) {
		return publicationRepostiory.save(publication);
	}

	@Transactional
	@Override
	public Publication updatePublication(Publication publication, long idpublicationOld) {
		publication.setId_Publication(idpublicationOld);
		return publicationRepostiory.save(publication);
	}
	@Transactional
	@Override
	public Publication getPublicationById(long idpublication) {
		return publicationRepostiory.findById(idpublication).get();
	}
	@Transactional
	@Override
	public void deletePublication(long idpublication) {
		publicationRepostiory.deleteById(idpublication);
	}
	@Transactional
	@Override
	public List<Publication> getAllPublication() {
		return (List<Publication>) publicationRepostiory.findAll();
	}

}
