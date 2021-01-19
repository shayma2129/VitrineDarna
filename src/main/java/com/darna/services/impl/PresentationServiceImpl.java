package com.darna.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.Presentation;
import com.darna.repository.PresentationRepository;
import com.darna.services.PresentationService;

@Service
public class PresentationServiceImpl implements PresentationService {
	
	@Autowired 
	private PresentationRepository presentationRepostiory;

	@Transactional
	@Override
	public Presentation addPresentation(Presentation presentation) {
		return presentationRepostiory.save(presentation);
	}

	@Transactional
	@Override
	public Presentation updatePresentation(Presentation presentation, long idpresOld) {
		presentation.setIdPresentation(idpresOld);
		return presentationRepostiory.save(presentation);
	}
	@Transactional
	@Override
	public Presentation getPresentationById(long idpres) {
		return presentationRepostiory.findById(idpres).get();
	}
	@Transactional
	@Override
	public void deletePresentation(long idpres) {
		presentationRepostiory.deleteById(idpres);
	}
	@Transactional
	@Override
	public List<Presentation> getAllPresentation() {
		return (List<Presentation>) presentationRepostiory.findAll();
	}

}
