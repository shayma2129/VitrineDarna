package com.darna.services;

import java.util.List;

import com.darna.models.Projet;

public interface ProjetService {
	
	public Projet addProjet(Projet projet);
	public Projet updateProjet(Projet projet,long idProjet);
	public Projet getProjetById(long idProjet);
	public void deleteProjet(long idProjet);
	public List<Projet> getAllProjet();

}
