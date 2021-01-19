package com.darna.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.darna.models.Document;
import com.darna.models.LienDoc;



@Repository
public interface LienDocRepository extends JpaRepository<LienDoc, Long> {
	
	@Query("SELECT  doc FROM LienDoc As liendoc, Document As doc\r\n" + 
			"WHERE liendoc.titre_liendoc LIKE 'Dern%' AND liendoc.idliendoc =doc.lienDoc")
	List<Document> findByLienDocDernierEtude();
	@Query("SELECT  doc FROM LienDoc As liendoc, Document As doc\r\n" + 
			"WHERE liendoc.titre_liendoc LIKE 'Droit%' AND liendoc.idliendoc =doc.lienDoc")
	List<Document> findByLienDocDroitEnfant();
	@Query("SELECT  doc FROM LienDoc As liendoc, Document As doc\r\n" + 
			"WHERE liendoc.titre_liendoc LIKE 'Associ%' AND liendoc.idliendoc =doc.lienDoc")
	List<Document> findByLienDocAssociation();
	
	@Query("SELECT  doc FROM LienDoc As liendoc, Document As doc\r\n" + 
			"WHERE liendoc.idliendoc=:id AND liendoc.idliendoc =doc.lienDoc")
	List<Document> findAllDocByIdLienDoc(@Param("id") long idliendoc);
	
}
