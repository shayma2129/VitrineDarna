package com.darna.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="PROJET")
@JsonInclude(value=Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Projet {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDProjet")
	private long id_projet;
	
	
    @Column(name="description_projet",columnDefinition="TEXT")
	private String description_projet;
    
    @Column(name="status_projet",length=120)
  	private String status_projet;
  
     @Column(name="image")
	 @Lob
	 private byte[] image;
     /**
      * Path logo
      */
     @Column(name="path_image",length=255)
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
	public Projet(long id_projet, String description_projet, String status_projet, byte[] image, String path_image) {
		super();
		this.id_projet = id_projet;
		this.description_projet = description_projet;
		this.status_projet = status_projet;
		this.image = image;
		this.path_image = path_image;
	}
	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
     
    

}
