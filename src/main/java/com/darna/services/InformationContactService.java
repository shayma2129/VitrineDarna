package com.darna.services;

import java.util.List;

import com.darna.models.InformationContact;

public interface InformationContactService {

	
	public InformationContact addInformationContact(InformationContact informationContact);
	 List<InformationContact> findAllItems();

	public  InformationContact findbyid(Long  id);
	
	public InformationContact updateInformationContact(Long id , InformationContact informationContact);
	public void deleteInformationContact(long id);

}

