package com.darna.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRESENTATION")
public class Presentation {
	/**
	 * Presentation Id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPresentation")
	private long idPresentation;
    
    /**
     * Description presentation
     */
    @Column(name="description_presentation",columnDefinition="TEXT")
	private String description_presentation;

	public Presentation(long idPresentation, String description_presentation) {
		super();
		this.idPresentation = idPresentation;
		this.description_presentation = description_presentation;
	}

	public Presentation() {
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
