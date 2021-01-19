package com.darna.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.darna.models.Action;
import com.darna.models.User;
import com.darna.models.UserAction;
import com.darna.models.pk.UserActionKey;




@Repository
public interface UserParticiperActionRepository extends CrudRepository<UserAction,Long> {
	Optional<UserAction> findById(UserActionKey id);
	@Query("SELECT  action FROM Action As action, UserAction As ua\r\n" + 
				"WHERE ua.user.id=:id and ua.action.id_Action=action.id_Action and ua.autorisation=true")
	List<Action> findActionByUser(@Param("id") long iduser);
	@Query("SELECT  user FROM User As user, UserAction As ua\r\n" + 
				"WHERE ua.action.id_Action=:id and ua.user.id=user.id and ua.autorisation=true")
	List<User> findUserByAction(@Param("id") long idaction);

	@Query("SELECT  user FROM User As user, UserAction As ua\r\n" + 
			"WHERE ua.action.id_Action=:id and ua.user.id=user.id and ua.autorisation=false")
    List<User> findUserByActionNotAccepted(@Param("id") long idaction);
	List<UserAction> findByAutorisation(Boolean autorisation);

}
