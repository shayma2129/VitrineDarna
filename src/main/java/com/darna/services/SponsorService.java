package com.darna.services;

import java.util.List;

import com.darna.models.Sponsor;


public interface SponsorService {
	
	public Sponsor addSponsor(Sponsor sponsor);
	public Sponsor updateSponsor(Sponsor sponsor,long idsponsorOld);
	public Sponsor getSponsorById(long idsponsor);
	public void deleteSponsor(long idsponsor);
	public List<Sponsor> getAllSponsor();

}
