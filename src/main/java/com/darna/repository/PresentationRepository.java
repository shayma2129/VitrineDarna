package com.darna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.Presentation;


@Repository
public interface PresentationRepository extends CrudRepository<Presentation, Long>{

}
