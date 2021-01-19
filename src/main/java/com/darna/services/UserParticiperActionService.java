package com.darna.services;

import java.util.List;

import com.darna.models.Action;
import com.darna.models.User;
import com.darna.models.UserAction;


public interface UserParticiperActionService {
	public UserAction participerAction(Long idU, Long idA);
	public UserAction getUserActionById(long idU, long idA) ;
	public List<UserAction> getAllUserAction();
	public List<Action> findActionByUser(long idU);
	public List<User> findUserByAction(long idA);
	
	public UserAction autoriserParticipation(Long idU, Long idA,Boolean autorisation);
	public List<User> getListDemandeParticipation(long idaction);
	public List<User> getListParticipationAutorise();

}
