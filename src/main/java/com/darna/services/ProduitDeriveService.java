package com.darna.services;

import java.io.InputStream;
import java.util.List;

import com.darna.models.ProduitDerive;


public interface ProduitDeriveService {
	
	
	public ProduitDerive addProduitDerive(ProduitDerive produitDerive);
	public ProduitDerive updateProduitDerive(Long id , ProduitDerive produitDerive);

	 List<ProduitDerive> findAllProduitDerive();

	public  ProduitDerive findbyid(Long  id);
	


	void saveFile (InputStream inputstream , String path );
	void updateFile (InputStream inputstream , String path );


	public void deleteProduitDerive(long id);


}
