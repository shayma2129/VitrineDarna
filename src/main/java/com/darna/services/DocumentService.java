package com.darna.services;

import java.util.List;

import com.darna.models.Document;


public interface DocumentService {
	
	public void addDocument(Document document);
	public List<Document> getAllDocument();
	public Document getDocument(long idDoc);
	public List<Document> getAllDocLienDoc(long idliendoc);
	public void deleteAllDocLienDoc(long idliendoc);
	public void deleteAllSlide(long idslide);

}
