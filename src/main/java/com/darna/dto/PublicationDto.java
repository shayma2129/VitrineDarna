package com.darna.dto;

public class PublicationDto {
	private long id_Publication;
	private String type_publication;
	private String lien_publication;
	private String description_publication;
	public PublicationDto(long id_Publication, String type_publication, String lien_publication,
			String description_publication) {
		super();
		this.id_Publication = id_Publication;
		this.type_publication = type_publication;
		this.lien_publication = lien_publication;
		this.description_publication = description_publication;
	}
	public PublicationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId_Publication() {
		return id_Publication;
	}
	public void setId_Publication(long id_Publication) {
		this.id_Publication = id_Publication;
	}
	public String getType_publication() {
		return type_publication;
	}
	public void setType_publication(String type_publication) {
		this.type_publication = type_publication;
	}
	public String getLien_publication() {
		return lien_publication;
	}
	public void setLien_publication(String lien_publication) {
		this.lien_publication = lien_publication;
	}
	public String getDescription_publication() {
		return description_publication;
	}
	public void setDescription_publication(String description_publication) {
		this.description_publication = description_publication;
	}
	
	

}
