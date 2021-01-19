package com.darna.services;

import java.util.List;

import com.darna.models.Document;
import com.darna.models.LienDoc;

public interface LienDocService {

	public LienDoc addLienDoc(LienDoc liendoc);
	public LienDoc updateLienDoc(LienDoc liendoc,long idldocold);
	public LienDoc getLienDocById(long idlien);
	public void deleteLienDoc(long idlien);
	public List<LienDoc> getAllLienDoc();
	public List<Document> getAllDroitEnfant();
	public List<Document> getAllDernierEtude();
	public List<Document> getAllAssociationDarna();
	public List<Document> getAllDocByIdLienDoc(long idlien);

}
