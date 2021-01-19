package com.darna.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.Projet;
import com.darna.repository.ProjetRepository;
import com.darna.services.ProjetService;

@Service
public class ProjetServiceImpl implements ProjetService{

	
	@Autowired 
	private ProjetRepository projetRepository;

	@Transactional
	@Override
	public Projet addProjet(Projet projet) {
		// TODO Auto-generated method stub
		return projetRepository.save(projet);
	}

	@Transactional
	@Override
	public Projet updateProjet(Projet projet, long idProjet) {
		// TODO Auto-generated method stub
		projet.setId_projet(idProjet);
		return projetRepository.save(projet);	}
	@Transactional
	@Override
	public Projet getProjetById(long idProjet) {
		// TODO Auto-generated method stub
		return projetRepository.findById(idProjet).get();
	}
	@Transactional
	@Override
	public void deleteProjet(long idProjet) {
		projetRepository.deleteById(idProjet);
		
	}
	@Transactional
	@Override
	public List<Projet> getAllProjet() {
		// TODO Auto-generated method stub
		return (List<Projet>) projetRepository.findAll();
	}

}
