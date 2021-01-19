package com.darna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.Contact;


@Repository
public interface ContactRepository extends  CrudRepository<Contact, Long> {

}
