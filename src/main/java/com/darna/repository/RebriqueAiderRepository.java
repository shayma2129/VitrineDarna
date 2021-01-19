package com.darna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.RebriqueAider;


@Repository
public interface RebriqueAiderRepository extends  CrudRepository<RebriqueAider, Long>{

}
