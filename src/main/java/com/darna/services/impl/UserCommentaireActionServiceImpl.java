package com.darna.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.darna.models.Action;
import com.darna.models.User;
import com.darna.models.UserCommentaireAction;
import com.darna.repository.ActionRepository;
import com.darna.repository.UserCommentaireActionRepository;
import com.darna.repository.UserRepository;
import com.darna.services.UserCommentaireActionService;

@Service
public class UserCommentaireActionServiceImpl implements UserCommentaireActionService {

	@Autowired
	UserCommentaireActionRepository userCommentaireActionRepository;
	
	@Autowired
	ActionRepository actionRepository;
	@Autowired
	UserRepository userRepository;
	String commentaire ;

	@Override
	public UserCommentaireAction addCommentaire(Long idU, Long idA,UserCommentaireAction userCommentaireAction) {
		User user = userRepository.findById(idU).get();		
		Action action = actionRepository.findById(idA).get();

		userCommentaireAction.setAction(action);
		userCommentaireAction.setUser(user);
		
		return userCommentaireActionRepository.save(userCommentaireAction);
	}

	@Override
	public List<UserCommentaireAction> findCommentaireByAction(long idA) {
	
					Action action = actionRepository.findById(idA).get();
					return userCommentaireActionRepository.getAllCommentaireByAction(action)	;
					
	
	}



	

}
