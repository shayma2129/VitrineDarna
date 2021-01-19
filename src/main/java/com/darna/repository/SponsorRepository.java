package com.darna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.Sponsor;


@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, Long> {

}
