package com.darna.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.Document;
import com.darna.models.LienDoc;
import com.darna.repository.LienDocRepository;
import com.darna.services.LienDocService;

@Service
public class LienDocServiceImpl implements LienDocService {
	
	@Autowired 
	private LienDocRepository liendocRepository;
	
	
	@Transactional
	@Override
	public LienDoc addLienDoc(LienDoc liendoc) {
		return liendocRepository.save(liendoc);
	}

	@Transactional
	@Override
	public LienDoc updateLienDoc(LienDoc liendoc, long idldocold) {
		liendoc.setIdliendoc(idldocold);
		return liendocRepository.save(liendoc);
	}
	@Transactional
	@Override
	public LienDoc getLienDocById(long idlien) {
		
		return liendocRepository.findById(idlien).get();
	}
	@Transactional
	@Override
	public void deleteLienDoc(long idlien) {
		liendocRepository.deleteById(idlien);
	}
	@Transactional
	@Override
	public List<LienDoc> getAllLienDoc() {
		
		return (List<LienDoc>) liendocRepository.findAll();
	}
	@Transactional
	@Override
	public List<Document> getAllDroitEnfant() {
		return  (List<Document>) liendocRepository.findByLienDocDroitEnfant();
	}
	@Transactional
	@Override
	public List<Document> getAllDernierEtude() {
		return  (List<Document>) liendocRepository.findByLienDocDernierEtude();
	}
	@Transactional
	@Override
	public List<Document> getAllAssociationDarna() {
		return  (List<Document>) liendocRepository.findByLienDocAssociation();
		}

	@Transactional
	@Override
	public List<Document> getAllDocByIdLienDoc(long idlien) {
		
		return (List<Document>) liendocRepository.findAllDocByIdLienDoc(idlien);
	}
	

}
