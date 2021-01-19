package com.darna.services;

import java.io.InputStream;
import java.util.List;

import com.darna.models.SpotVideo;



public interface SpotVideoService {
	
	
	public SpotVideo addSpotVideo(SpotVideo spotVideo);
	public SpotVideo updateSpotVideo(Long id , SpotVideo spotVideo);

	 List<SpotVideo> findAllSpotVideo();

	public  SpotVideo findbyid(Long  id);
		void saveFile (InputStream inputstream , String path );
	public void deleteSpotVideo(long id);

}
