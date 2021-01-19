package com.darna.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.Contact;
import com.darna.repository.ContactRepository;
import com.darna.services.ContactService;

@Service
public class ContactImpl implements ContactService {
	

	@Autowired
    ContactRepository contactRepository;
	
	@Transactional
	@Override
	public Contact addContact(Contact contact) {
		
			    return contactRepository.save(contact);
	
	}

	@Override
	public List<Contact> findAllItems() {
		// TODO Auto-generated method stub
		return (List<Contact>) contactRepository.findAll();
	}

	@Override
	public Contact findbyid(Long id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id).get();
	}

	@Override
	public void deleteContact(long id) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(id);
	}

}
