package com.darna.dto;

import java.util.Calendar;
import java.util.Date;


public class ActionDto {

	/**
	 * Id action
	 */
	private long id_Action;
	
	 /**
     * Nom action 
     */
    
	private String nom_action;
    /**
     * Description action 
     */
	 private String description_action;
    /**
     * Photo action
     */
	 private byte[] photo;
     /**
      * Path logo
      */
     private String path_photo;
     /**
      * Lieu action 
      */
 	 private String lieu_action;
     /**
      * Date début action 
      */
 	 private Date datedebut_action;
     /**
      * Date fin action 
      */
 	 private Date datefin_action;
     /**
      * Date début d'inscription 
      */
 	 private Calendar datedebut_inscrit;
     /**
      * Date fin d'inscription
      */
 	 private Calendar datefin_inscrit;
     /**
      * Etat action 
      */
 	 private Boolean etat_action;
     /**
      * Nombre de membres  
      */
 	 private Long nbmembre_action;
	public ActionDto(long id_Action, String nom_action, String description_action, byte[] photo, String path_photo,
			String lieu_action, Date datedebut_action, Date datefin_action, Calendar datedebut_inscrit,
			Calendar datefin_inscrit, Boolean etat_action, Long nbmembre_action) {
		super();
		this.id_Action = id_Action;
		this.nom_action = nom_action;
		this.description_action = description_action;
		this.photo = photo;
		this.path_photo = path_photo;
		this.lieu_action = lieu_action;
		this.datedebut_action = datedebut_action;
		this.datefin_action = datefin_action;
		this.datedebut_inscrit = datedebut_inscrit;
		this.datefin_inscrit = datefin_inscrit;
		this.etat_action = etat_action;
		this.nbmembre_action = nbmembre_action;
	}
	public ActionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId_Action() {
		return id_Action;
	}
	public void setId_Action(long id_Action) {
		this.id_Action = id_Action;
	}
	public String getNom_action() {
		return nom_action;
	}
	public void setNom_action(String nom_action) {
		this.nom_action = nom_action;
	}
	public String getDescription_action() {
		return description_action;
	}
	public void setDescription_action(String description_action) {
		this.description_action = description_action;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getPath_photo() {
		return path_photo;
	}
	public void setPath_photo(String path_photo) {
		this.path_photo = path_photo;
	}
	public String getLieu_action() {
		return lieu_action;
	}
	public void setLieu_action(String lieu_action) {
		this.lieu_action = lieu_action;
	}
	public Date getDatedebut_action() {
		return datedebut_action;
	}
	public void setDatedebut_action(Date datedebut_action) {
		this.datedebut_action = datedebut_action;
	}
	public Date getDatefin_action() {
		return datefin_action;
	}
	public void setDatefin_action(Date datefin_action) {
		this.datefin_action = datefin_action;
	}
	public Calendar getDatedebut_inscrit() {
		return datedebut_inscrit;
	}
	public void setDatedebut_inscrit(Calendar datedebut_inscrit) {
		this.datedebut_inscrit = datedebut_inscrit;
	}
	public Calendar getDatefin_inscrit() {
		return datefin_inscrit;
	}
	public void setDatefin_inscrit(Calendar datefin_inscrit) {
		this.datefin_inscrit = datefin_inscrit;
	}
	public Boolean getEtat_action() {
		return etat_action;
	}
	public void setEtat_action(Boolean etat_action) {
		this.etat_action = etat_action;
	}
	public Long getNbmembre_action() {
		return nbmembre_action;
	}
	public void setNbmembre_action(Long nbmembre_action) {
		this.nbmembre_action = nbmembre_action;
	}
 	 
}
