package com.darna.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.ProduitDerive;
import com.darna.repository.ProduitDeriveRepository;
import com.darna.services.ProduitDeriveService;

@Service
public class ProduitDeriveImpl implements ProduitDeriveService{

	
	@Autowired
	ProduitDeriveRepository produitDeriveRepository;
	
	@Transactional
	@Override
	public ProduitDerive addProduitDerive(ProduitDerive produitDerive) {
		// TODO Auto-generated method stub
		return produitDeriveRepository.save(produitDerive);
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
	public ProduitDerive updateProduitDerive(Long id, ProduitDerive produitDerive) {
			// TODO Auto-generated method stub
		produitDerive.setId(id);
	        return produitDeriveRepository.save(produitDerive);
	       
	}
	@Transactional
	@Override
	public List<ProduitDerive> findAllProduitDerive() {
		// TODO Auto-generated method stub
		return (List<ProduitDerive>) produitDeriveRepository.findAll();
	}

	@Transactional
	@Override
	public ProduitDerive findbyid(Long id) {
		// TODO Auto-generated method stub
		return produitDeriveRepository.findById(id).get();
	}



	@Override
	public void updateFile(InputStream inputstream, String path) {
		// TODO Auto-generated method stub
		
	}
	@Transactional
	@Override
	public void deleteProduitDerive(long id) {
		// TODO Auto-generated method stub

			 produitDeriveRepository.deleteById(id);

		
	}
	
	

}
