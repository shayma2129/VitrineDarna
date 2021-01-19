package com.darna.dto;

public class SponsorDto {
	
	private long id_Sponsor;
	private String intitule_sponsor;
	private byte[] logo;
	private String path_logo;
	public SponsorDto(long id_Sponsor, String intitule_sponsor, byte[] logo, String path_logo) {
		super();
		this.id_Sponsor = id_Sponsor;
		this.intitule_sponsor = intitule_sponsor;
		this.logo = logo;
		this.path_logo = path_logo;
	}
	public SponsorDto() {
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
