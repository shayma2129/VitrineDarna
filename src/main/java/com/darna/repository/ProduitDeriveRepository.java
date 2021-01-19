package com.darna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.ProduitDerive;

@Repository
public interface ProduitDeriveRepository extends  CrudRepository<ProduitDerive, Long>{
}
