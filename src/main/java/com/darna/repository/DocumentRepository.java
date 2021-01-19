package com.darna.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.Document;
import com.darna.models.LienDoc;
import com.darna.models.Slide;

@Repository
public interface DocumentRepository extends CrudRepository<Document,Long>{

	List<Document> findByLienDoc(LienDoc liendoc);
	List<Document> findBySlide(Slide slide);
	void deleteByLienDoc(LienDoc lienDoc);
	void deleteBySlide(Slide slide);
}
