package com.darna.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.darna.models.Role;
import com.darna.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);

	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	List<User> findAll();
	
	//@Query( "select u from User u inner join u.roles r where r.name LIKE 'ROLE_ADMIN' OR r.name LIKE 'ROLE_USER'" )
	@Query( "select u from User u inner join u.roles r where r.name LIKE 'ROLE_ADMIN' OR r.name LIKE 'ROLE_USER' OR r.name LIKE 'ROLE_VISITEUR' OR r.name LIKE 'ROLE_MEMBRE'" )
	List<User> findBySpecificRoles(@Param("roles") List<Role> roles);
	
	
	
	
	
}
