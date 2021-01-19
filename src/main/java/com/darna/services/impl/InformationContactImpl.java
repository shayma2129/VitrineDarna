package com.darna.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.InformationContact;
import com.darna.repository.InformationContactRepository;
import com.darna.services.InformationContactService;

@Service
public class InformationContactImpl implements InformationContactService {


	@Autowired
	InformationContactRepository informationContactRepository;
	
	@Transactional
	@Override
	public InformationContact addInformationContact(InformationContact informationContact) {
		// TODO Auto-generated method stub
		return informationContactRepository.save(informationContact);
	}

	@Override
	public List<InformationContact> findAllItems() {
		// TODO Auto-generated method stub
		return (List<InformationContact>) informationContactRepository.findAll();
	}

	@Override
	public InformationContact findbyid(Long id) {
		// TODO Auto-generated method stub
		return informationContactRepository.findById(id).get();
	}

	@Override
	public InformationContact updateInformationContact(Long id, InformationContact informationContact) {
		// TODO Auto-generated method stub
		informationContact.setId(id);
		return informationContactRepository.save(informationContact);
	}

	@Override
	public void deleteInformationContact(long id) {
		// TODO Auto-generated method stub
		informationContactRepository.deleteById(id);
		
	}

}
