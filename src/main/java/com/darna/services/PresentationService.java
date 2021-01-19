package com.darna.services;

import java.util.List;

import com.darna.models.Presentation;

public interface PresentationService {

	public Presentation addPresentation(Presentation presentation);
	public Presentation updatePresentation(Presentation presentation,long idpresOld);
	public Presentation getPresentationById(long idpres);
	public void deletePresentation(long idpres);
	public List<Presentation> getAllPresentation();
}
