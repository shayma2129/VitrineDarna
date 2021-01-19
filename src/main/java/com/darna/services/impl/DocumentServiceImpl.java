package com.darna.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.Document;
import com.darna.models.LienDoc;
import com.darna.models.Slide;
import com.darna.repository.DocumentRepository;
import com.darna.repository.LienDocRepository;
import com.darna.repository.SlideRepository;
import com.darna.services.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired 
	private DocumentRepository documentRepository;
	@Autowired
	private LienDocRepository liendocRepository;
	@Autowired
	private SlideRepository slideRepository;

	@Transactional
	@Override
	public void addDocument(Document document) {
		 documentRepository.save(document);
	}

	@Transactional
	@Override
	public List<Document> getAllDocument() {
		return (List<Document>) documentRepository.findAll();
	}
	@Transactional
	@Override
	public Document getDocument(long idDoc) {
		return documentRepository.findById(idDoc).get();
	}
	@Transactional
	@Override
	public List<Document> getAllDocLienDoc(long idliendoc) {
		LienDoc liendoc=liendocRepository.findById(idliendoc).get();
		return documentRepository.findByLienDoc(liendoc);
	}
	@Transactional
	@Override
	public void deleteAllDocLienDoc(long idliendoc) {
		LienDoc liendoc=liendocRepository.findById(idliendoc).get();
		documentRepository.deleteByLienDoc(liendoc);
	}
	@Transactional
	@Override
	public void deleteAllSlide(long idslide) {
		Slide slide=slideRepository.findById(idslide).get();
		documentRepository.deleteBySlide(slide);
	}

}
