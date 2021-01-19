package com.darna.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.Publication;


@Repository
public interface PublicationRepository extends CrudRepository<Publication, Long> {

	//public List<Publication> findByType_publication();
}
