package com.darna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.Slide;

@Repository
public interface SlideRepository extends CrudRepository<Slide,Long> {

}
