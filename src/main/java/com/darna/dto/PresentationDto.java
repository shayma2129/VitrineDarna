package com.darna.dto;

public class PresentationDto {
	
	private long idPresentation;
	private String description_presentation;
	
	public PresentationDto(long idPresentation, String description_presentation) {
		super();
		this.idPresentation = idPresentation;
		this.description_presentation = description_presentation;
	}

	public PresentationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdPresentation() {
		return idPresentation;
	}

	public void setIdPresentation(long idPresentation) {
		this.idPresentation = idPresentation;
	}

	public String getDescription_presentation() {
		return description_presentation;
	}

	public void setDescription_presentation(String description_presentation) {
		this.description_presentation = description_presentation;
	}
	
	

}
