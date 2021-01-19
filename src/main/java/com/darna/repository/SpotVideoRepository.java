package com.darna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.SpotVideo;


@Repository

public interface SpotVideoRepository extends  CrudRepository<SpotVideo, Long> {
	

}
