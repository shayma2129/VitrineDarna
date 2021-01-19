package com.darna.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.RebriqueAider;
import com.darna.repository.RebriqueAiderRepository;
import com.darna.services.RebriqueAiderService;

@Service
public class RebriqueAiderImpl  implements RebriqueAiderService{
	@Autowired
	RebriqueAiderRepository rebriqueAiderRepository;
	
	
	@Transactional
	@Override
	public RebriqueAider addRebriqueAider(RebriqueAider rebriqueAider) {
		// TODO Auto-generated method stub
		return rebriqueAiderRepository.save(rebriqueAider);
	}

	@Transactional
	@Override
	public List<RebriqueAider> findAllItems() {
		// TODO Auto-generated method stub
		return (List<RebriqueAider>) rebriqueAiderRepository.findAll();
	}

	@Transactional
	@Override
	public RebriqueAider findbyid(Long id) {
		// TODO Auto-generated method stub
		return rebriqueAiderRepository.findById(id).get();
	}



	
	@Transactional
	@Override
	public RebriqueAider updateRebrique(Long id, RebriqueAider rebriqueAider) {
		// TODO Auto-generated method stub
		rebriqueAider.setId(id);
        return rebriqueAiderRepository.save(rebriqueAider);
        }

	@Override
	public void deleteRebriqueAider(long id) {
		// TODO Auto-generated method stub
		rebriqueAiderRepository.deleteById(id);
	}

}
