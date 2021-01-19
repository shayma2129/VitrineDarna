package com.darna.dto;


public class ProjetDto {
	
    private long id_projet;	
	private String description_projet;    
  	private String status_projet;
    private byte[] image;
   private String path_image;
public long getId_projet() {
	return id_projet;
}
public void setId_projet(long id_projet) {
	this.id_projet = id_projet;
}
public String getDescription_projet() {
	return description_projet;
}
public void setDescription_projet(String description_projet) {
	this.description_projet = description_projet;
}
public String getStatus_projet() {
	return status_projet;
}
public void setStatus_projet(String status_projet) {
	this.status_projet = status_projet;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}
public String getPath_image() {
	return path_image;
}
public void setPath_image(String path_image) {
	this.path_image = path_image;
}
public ProjetDto() {
	super();
	// TODO Auto-generated constructor stub
}
   
	

}
