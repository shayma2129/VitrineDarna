package com.darna.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="InformationContact")
public class InformationContact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name="Map",length=120)
	private String map;
    
	private String adresse;
	private String tél;
    
	@Size(max = 50)
	@Email
	private String email;

	private String président;	    
	@Size(max = 50)
	@Email
	private String email_P;
		
	private String vice_Président;	    
	@Size(max = 50)
	@Email
	private String email_V;
	

	private String s_génerale;	    
	@Size(max = 50)
	@Email
	private String email_S;
    
	private String trésorie;	    
	
	@Size(max = 50)
	@Email
	private String email_T;
	
	private String lien_FB;
	private String lien_Insta;
	private String lien_Twitter;
	private String lien_Tumb;
	private String lien_Youtube;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTél() {
		return tél;
	}
	public void setTél(String tél) {
		this.tél = tél;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPrésident() {
		return président;
	}
	public void setPrésident(String président) {
		this.président = président;
	}
	public String getEmail_P() {
		return email_P;
	}
	public void setEmail_P(String email_P) {
		this.email_P = email_P;
	}
	public String getVice_Président() {
		return vice_Président;
	}
	public void setVice_Président(String vice_Président) {
		this.vice_Président = vice_Président;
	}
	public String getEmail_V() {
		return email_V;
	}
	public void setEmail_V(String email_V) {
		this.email_V = email_V;
	}
	public String getS_génerale() {
		return s_génerale;
	}
	public void setS_génerale(String s_génerale) {
		this.s_génerale = s_génerale;
	}
	public String getEmail_S() {
		return email_S;
	}
	public void setEmail_S(String email_S) {
		this.email_S = email_S;
	}
	public String getTrésorie() {
		return trésorie;
	}
	public void setTrésorie(String trésorie) {
		this.trésorie = trésorie;
	}
	public String getEmail_T() {
		return email_T;
	}
	public void setEmail_T(String email_T) {
		this.email_T = email_T;
	}
	public String getLien_FB() {
		return lien_FB;
	}
	public void setLien_FB(String lien_FB) {
		this.lien_FB = lien_FB;
	}
	public String getLien_Insta() {
		return lien_Insta;
	}
	public void setLien_Insta(String lien_Insta) {
		this.lien_Insta = lien_Insta;
	}
	public String getLien_Twitter() {
		return lien_Twitter;
	}
	public void setLien_Twitter(String lien_Twitter) {
		this.lien_Twitter = lien_Twitter;
	}
	public String getLien_Tumb() {
		return lien_Tumb;
	}
	public void setLien_Tumb(String lien_Tumb) {
		this.lien_Tumb = lien_Tumb;
	}
	public String getLien_Youtube() {
		return lien_Youtube;
	}
	public void setLien_Youtube(String lien_Youtube) {
		this.lien_Youtube = lien_Youtube;
	}
	public InformationContact(Long id, String map, String adresse, String tél, @Size(max = 50) @Email String email,
			String président, @Size(max = 50) @Email String email_P, String vice_Président,
			@Size(max = 50) @Email String email_V, String s_génerale, @Size(max = 50) @Email String email_S,
			String trésorie, @Size(max = 50) @Email String email_T, String lien_FB, String lien_Insta,
			String lien_Twitter, String lien_Tumb, String lien_Youtube) {
		super();
		this.id = id;
		this.map = map;
		this.adresse = adresse;
		this.tél = tél;
		this.email = email;
		this.président = président;
		this.email_P = email_P;
		this.vice_Président = vice_Président;
		this.email_V = email_V;
		this.s_génerale = s_génerale;
		this.email_S = email_S;
		this.trésorie = trésorie;
		this.email_T = email_T;
		this.lien_FB = lien_FB;
		this.lien_Insta = lien_Insta;
		this.lien_Twitter = lien_Twitter;
		this.lien_Tumb = lien_Tumb;
		this.lien_Youtube = lien_Youtube;
	}
	public InformationContact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	}
