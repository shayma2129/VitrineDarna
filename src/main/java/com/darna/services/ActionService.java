package com.darna.services;

import java.util.List;

import com.darna.models.Action;

public interface ActionService {

	public Action addAction(Action action);
	public Action updateAction(Action action,long idaction_old);
	public Action getActionById(long idact);
	public void deleteAction(long id);
	public List<Action> getAllAction();	
	//public List<Action> VerifListAction();	
	public Action publierAction(Long idAction,boolean etat);
}
