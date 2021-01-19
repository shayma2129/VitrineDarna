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
@Table(name="SPONSOR")
@JsonInclude(value=Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Sponsor {
	
	/**
	 * Id sponsor
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDSponsor")
	private long id_Sponsor;
	
	 /**
     * Intitule sponsor 
     */
    @Column(name="intitule_sponsor",length=120)
	private String intitule_sponsor;
    
    /**
     * Logo sponsor
     */
     @Column(name="logo")
	 @Lob
	 private byte[] logo;
     /**
      * Path logo
      */
     @Column(name="path_logo",length=255)
     private String path_logo;
     
     
	public Sponsor(long id_Sponsor, String intitule_sponsor, byte[] logo, String path_logo) {
		super();
		this.id_Sponsor = id_Sponsor;
		this.intitule_sponsor = intitule_sponsor;
		this.logo = logo;
		this.path_logo = path_logo;
	}
	public Sponsor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId_Sponsor() {
		return id_Sponsor;
	}
	public void setId_Sponsor(long id_Sponsor) {
		this.id_Sponsor = id_Sponsor;
	}
	public String getIntitule_sponsor() {
		return intitule_sponsor;
	}
	public void setIntitule_sponsor(String intitule_sponsor) {
		this.intitule_sponsor = intitule_sponsor;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public String getPath_logo() {
		return path_logo;
	}
	public void setPath_logo(String path_logo) {
		this.path_logo = path_logo;
	}
     
     

}
