package com.darna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.Objectif;

@Repository
public interface ObjectifRepository  extends CrudRepository<Objectif, Long>{

}
