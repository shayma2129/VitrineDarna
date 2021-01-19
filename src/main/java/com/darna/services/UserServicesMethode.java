package com.darna.services;

import java.io.InputStream;

import com.darna.models.User;


public interface UserServicesMethode {
	void saveFile (InputStream inputstream , String path );
	public User updateUser(Long id , User user);

	public User getAUserById(long Userid) ;
	public void deleteUser(long id);

}
