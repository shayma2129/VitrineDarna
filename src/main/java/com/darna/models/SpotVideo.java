package com.darna.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="SpotVideo")
public class SpotVideo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="PATH")
	private String path;
	/**
	 * file
	 */
	 @Column
	 @Lob
	 private byte[] file;
	 
	 private String nom_Entreprise;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getNom_Entreprise() {
		return nom_Entreprise;
	}

	public void setNom_Entreprise(String nom_Entreprise) {
		this.nom_Entreprise = nom_Entreprise;
	}

	public SpotVideo(Long id, String path, byte[] file, String nom_Entreprise) {
		super();
		this.id = id;
		this.path = path;
		this.file = file;
		this.nom_Entreprise = nom_Entreprise;
	}

	public SpotVideo() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	 

}
