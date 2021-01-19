package com.darna.services;

import java.util.List;

import com.darna.models.Publication;


public interface PublicationService {
	
	public Publication addPublication(Publication publication);
	public Publication updatePublication(Publication publication,long idpublicationOld);
	public Publication getPublicationById(long idpublication);
	public void deletePublication(long idpublication);
	public List<Publication> getAllPublication();

}
