package com.darna.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.Objectif;
import com.darna.repository.ObjectifRepository;
import com.darna.services.ObjectifService;


@Service
public class ObjectifServiceImpl implements ObjectifService {

	@Autowired 
	private ObjectifRepository objectifRepository;

	@Transactional
	@Override
	public Objectif addObjectif(Objectif objectif) {
		return objectifRepository.save(objectif);
	}
	@Transactional
	@Override
	public Objectif updateObjectif(Objectif obj, long idobjold) {
		//Objectif old_Objectif=getObjectifById(idobjold);
		obj.setIdObjectif(idobjold);
		return objectifRepository.save(obj);
	}
	@Transactional
	@Override
	public Objectif getObjectifById(long idobj) {
		return objectifRepository.findById(idobj).get();
	}
	@Transactional
	@Override
	public void deleteObjectif(long id) {
		objectifRepository.deleteById(id);
	}
	@Transactional
	@Override
	public List<Objectif> getAllObjectif() {
		return (List<Objectif>) objectifRepository.findAll();
	}
}
