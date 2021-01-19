package com.darna.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.User;
import com.darna.repository.UserRepository;
import com.darna.response.MessageResponse;




@Service
public  class UserService implements UserServicesMethode  {
	
	@Autowired
	UserRepository userRepository  ;
	

	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	
	
	
	public MessageResponse activate(Long id) {
		
		User user = userRepository.findById(id).orElse(null);
		if(user==null) {
			return new MessageResponse("Utilisateur n'existe pas");
		}
		
		user.setEnabled(!user.isEnabled());
		userRepository.save(user);
		return new MessageResponse("Opération effectuée avec succès");
	}
	
	
	@Override
	@Transactional
	public void saveFile(InputStream inputstream, String path) {
		 try {
				OutputStream outputstream = new FileOutputStream(new File (path));
				int read =0;
				byte []bytes = new byte[1024];
				while((read = inputstream.read(bytes)) != -1) {
					outputstream.write(bytes, 0, read);
				}
				
				outputstream.flush();
				outputstream.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}



	@Transactional
	@Override
	public User updateUser(Long id, User user) {

	
			// TODO Auto-generated method stub
			user.setId(id);
	        return userRepository.save(user);	
	        
	}		
	
	
	@Transactional
	@Override
	public User getAUserById(long Userid) {
		return userRepository.findById(Userid).get();
	}




	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
		
	}



  

	
	
}
