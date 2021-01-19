package com.darna.dto;


public class SpotVideoDto {

	
	private Long id;

	private String path;
	/**
	 * file
	 */
	
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

	public SpotVideoDto(Long id, String path, byte[] file, String nom_Entreprise) {
		super();
		this.id = id;
		this.path = path;
		this.file = file;
		this.nom_Entreprise = nom_Entreprise;
	}

	public SpotVideoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	 


}
