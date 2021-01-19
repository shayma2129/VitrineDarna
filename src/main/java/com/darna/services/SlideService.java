package com.darna.services;

import java.util.List;

import com.darna.models.Document;
import com.darna.models.Slide;

public interface SlideService {

	public Slide addSlide(Slide slide);
	public Slide updateSlide(long idS , Slide slide);
	public Slide getSlide(long idslide);
	public List<Document> getAllImageSlide(long idslide);
	public void deleteAllSlide(long idslide);
}
