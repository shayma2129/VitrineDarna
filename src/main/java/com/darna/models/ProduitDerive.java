package com.darna.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="ProduitDerive")
public class ProduitDerive {
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
	public ProduitDerive(Long id, String path, byte[] file) {
		super();
		this.id = id;
		this.path = path;
		this.file = file;
	}
	public ProduitDerive() {
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
