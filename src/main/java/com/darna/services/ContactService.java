package com.darna.services;

import java.util.List;

import com.darna.models.Contact;

public interface ContactService {
	
	
	public Contact addContact(Contact contact);
	
	 List<Contact> findAllItems();

		public  Contact findbyid(Long  id);
		
		public void deleteContact(long id);

}
