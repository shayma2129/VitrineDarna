package com.darna.services;

import java.util.List;

import com.darna.models.Objectif;

public interface ObjectifService {
	public Objectif addObjectif(Objectif objectif);
	public Objectif updateObjectif(Objectif obj,long idobjold);
	public Objectif getObjectifById(long idobj);
	public void deleteObjectif(long id);
	public List<Objectif> getAllObjectif();
}
