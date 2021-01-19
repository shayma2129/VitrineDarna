package com.darna.services;

import java.util.List;

import com.darna.models.RebriqueAider;

public interface RebriqueAiderService {

	
	public RebriqueAider addRebriqueAider(RebriqueAider rebriqueAider);
	 List<RebriqueAider> findAllItems();

	public  RebriqueAider findbyid(Long  id);
	
	public RebriqueAider updateRebrique(Long id , RebriqueAider rebriqueAider);
	public void deleteRebriqueAider(long id);

}
