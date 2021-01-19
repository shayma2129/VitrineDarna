package com.darna.dto;

public class ObjectifDto {

	private long idObjectif;
	private String description_objectif;
	public ObjectifDto(long idObjectif, String description_objectif) {
		super();
		this.idObjectif = idObjectif;
		this.description_objectif = description_objectif;
	}
	public ObjectifDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdObjectif() {
		return idObjectif;
	}
	public void setIdObjectif(long idObjectif) {
		this.idObjectif = idObjectif;
	}
	public String getDescription_objectif() {
		return description_objectif;
	}
	public void setDescription_objectif(String description_objectif) {
		this.description_objectif = description_objectif;
	}
	
}
