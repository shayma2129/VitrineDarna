package com.darna.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PUBLICATION")
public class Publication {
	
	/**
	 * Id publication
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPublication")
	private long id_Publication;
	
	 /**
     * Type publication 
     */
    @Column(name="type_publication",length=120)
	private String type_publication;
    /**
     * lien publication 
     */
    @Column(name="lien_publication",length=255)
	private String lien_publication;
    /**
     * Description publication 
     */
    @Column(name="description_publication",columnDefinition="TEXT")
	private String description_publication;
	public Publication(long id_Publication, String type_publication, String lien_publication,
			String description_publication) {
		super();
		this.id_Publication = id_Publication;
		this.type_publication = type_publication;
		this.lien_publication = lien_publication;
		this.description_publication = description_publication;
	}
	public Publication() {
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
