package com.darna.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.Action;


@Repository
public interface ActionRepository extends  CrudRepository<Action, Long> {

}
