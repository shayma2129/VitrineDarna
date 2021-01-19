package com.darna.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.Sponsor;
import com.darna.repository.SponsorRepository;
import com.darna.services.SponsorService;

@Service
public class SponsorServiceImpl implements SponsorService {
	
	@Autowired 
	private SponsorRepository sponsorRepository;

	@Transactional
	@Override
	public Sponsor addSponsor(Sponsor sponsor) {
		return sponsorRepository.save(sponsor);
	}

	@Transactional
	@Override
	public Sponsor updateSponsor(Sponsor sponsor, long idsponsorOld) {
		sponsor.setId_Sponsor(idsponsorOld);
		return sponsorRepository.save(sponsor);
	}
	@Transactional
	@Override
	public Sponsor getSponsorById(long idsponsor) {
		return sponsorRepository.findById(idsponsor).get();
	}
	@Transactional
	@Override
	public void deleteSponsor(long idsponsor) {
		sponsorRepository.deleteById(idsponsor);
	}
	@Transactional
	@Override
	public List<Sponsor> getAllSponsor() {
		return (List<Sponsor>) sponsorRepository.findAll();
	}

}
