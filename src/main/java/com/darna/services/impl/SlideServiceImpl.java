package com.darna.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.Document;
import com.darna.models.Slide;
import com.darna.repository.DocumentRepository;
import com.darna.repository.SlideRepository;
import com.darna.services.SlideService;

@Service
public class SlideServiceImpl implements SlideService {
	
	@Autowired 
	private SlideRepository slideRepository;
	@Autowired 
	private DocumentRepository documentRepository;

	@Transactional
	@Override
	public Slide addSlide(Slide slide) {
		return slideRepository.save(slide);
	}
	@Transactional
	@Override
	public Slide updateSlide(long idS, Slide slide) {
		slide.setIdSlide(idS);
		return slideRepository.save(slide);
	}
	
	@Transactional
	@Override
	public Slide getSlide(long idslide) {
		return slideRepository.findById(idslide).get();
	}
	
	@Transactional
	@Override
	public void deleteAllSlide(long idslide) {
		slideRepository.deleteById(idslide);
	}
	@Transactional
	@Override
	public List<Document> getAllImageSlide(long idslide) {
		Slide slide=getSlide(idslide);
		return documentRepository.findBySlide(slide);
	}

}
