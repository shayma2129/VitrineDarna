package com.darna.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darna.models.Action;
import com.darna.models.UserCommentaireAction;


@Repository
public interface UserCommentaireActionRepository  extends CrudRepository<UserCommentaireAction,Long>{
	List<UserCommentaireAction> getAllCommentaireByAction(Action action);

}
