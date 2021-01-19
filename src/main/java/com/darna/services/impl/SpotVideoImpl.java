package com.darna.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darna.models.SpotVideo;
import com.darna.repository.SpotVideoRepository;
import com.darna.services.SpotVideoService;

@Service
public class SpotVideoImpl implements SpotVideoService{

	@Autowired
	SpotVideoRepository spotVideoRepository;
	
	@Transactional
	@Override
	public SpotVideo addSpotVideo(SpotVideo spotVideo) {
		// TODO Auto-generated method stub
		return spotVideoRepository.save(spotVideo);
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
	public SpotVideo updateSpotVideo(Long id, SpotVideo spotVideo) {
	
				// TODO Auto-generated method stub
		spotVideo.setId(id);
		        return spotVideoRepository.save(spotVideo);
		       
		
	}

	
	@Override
	public List<SpotVideo> findAllSpotVideo() {
		// TODO Auto-generated method stub
		return (List<SpotVideo>) spotVideoRepository.findAll();
	}

	@Override
	public SpotVideo findbyid(Long id) {
		// TODO Auto-generated method stub
		return spotVideoRepository.findById(id).get();
	}

	@Override
	public void deleteSpotVideo(long id) {
		spotVideoRepository.deleteById(id);
	}

}
