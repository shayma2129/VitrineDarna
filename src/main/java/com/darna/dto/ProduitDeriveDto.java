package com.darna.dto;


public class ProduitDeriveDto {

	
	private Long id;
 
	private String path;
    byte[] file;
	public ProduitDeriveDto(Long id, String path, byte[] file) {
		super();
		this.id = id;
		this.path = path;
		this.file = file;
	}
	public ProduitDeriveDto() {
		super();
		// TODO Auto-generated constructor stub
	}
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
    
		
}
