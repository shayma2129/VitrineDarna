package com.darna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.Projet;


@Repository
public interface ProjetRepository extends CrudRepository<Projet, Long> {

}