package com.darna.services;

import java.util.List;

import com.darna.models.UserCommentaireAction;

public interface UserCommentaireActionService {

	public UserCommentaireAction addCommentaire(Long idU, Long idA, UserCommentaireAction userCommentaireAction);
	public List<UserCommentaireAction> findCommentaireByAction(long idA);

}
