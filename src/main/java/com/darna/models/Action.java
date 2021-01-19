package com.darna.models;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="ACTION")
@JsonInclude(value=Include.NON_NULL)
public class Action {

	/**
	 * Id action
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDAction")
	private long id_Action;
	
	 /**
     * Nom action 
     */
    @Column(name="nom_action",length=120)
	private String nom_action;
    /**
     * Description action 
     */
     @Column(name="description_action",columnDefinition="TEXT")
	 private String description_action;
    /**
     * Photo action
     */
     @Column(name="photo")
	 @Lob
	 private byte[] photo;
     /**
      * Path logo
      */
     @Column(name="path_photo",length=255)
     private String path_photo;
     /**
      * Lieu action 
      */
     @Column(name="lieu_action",length=120)
 	 private String lieu_action;
     /**
      * Date début action 
      */
     @Column(name="datedebut_action",length=60)
 	 private Date datedebut_action;
     /**
      * Date fin action 
      */
     @Column(name="datefin_action",length=60)
 	 private Date datefin_action;
     /**
      * Date début d'inscription 
      */
     @NotBlank
     @Column(name="datedebut_inscrit",length=60)
 	 private Calendar datedebut_inscrit;
     /**
      * Date fin d'inscription
      */
     @NotBlank
     @Column(name="datefin_inscrit",length=60)
 	 private Calendar datefin_inscrit;
     /**
      * Etat action 
      */
     @Column(name="etat_action")
 	 private Boolean etat_action;
     /**
      * Nombre de membres fixe 
      */
     @Column(name="nbmembrefixe_action",length=120)
 	 private Long nbmembrefixe_action;
     /**
      * Nombre de membres  
      */
     @Column(name="nbmembre_action",length=120)
 	 private Long nbmembre_action;
     
     @JsonIgnore
     @OneToMany(mappedBy = "action")
     Set<UserAction> userAction;
  
     @JsonIgnore
     @OneToMany(mappedBy = "action")
     Set<UserCommentaireAction> userCommentaireAction;
     
     /**
	  * Notification
	  */
	 @OneToMany(cascade = CascadeType.ALL,mappedBy = "action")
	 private Set<Notification> notifications = new HashSet<>();
     
	
	public Action(long id_Action, String nom_action, String description_action, byte[] photo, String path_photo,
			String lieu_action, Date datedebut_action, Date datefin_action, Calendar datedebut_inscrit,
			Calendar datefin_inscrit, Boolean etat_action, Long nbmembrefixe_action, Long nbmembre_action,
			Set<UserAction> userAction, Set<UserCommentaireAction> userCommentaireAction,
			Set<Notification> notifications) {
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
		this.nbmembrefixe_action = nbmembrefixe_action;
		this.nbmembre_action = nbmembre_action;
		this.userAction = userAction;
		this.userCommentaireAction = userCommentaireAction;
		this.notifications = notifications;
	}
	public Set<UserAction> getUserAction() {
		return userAction;
	}
	public void setUserAction(Set<UserAction> userAction) {
		this.userAction = userAction;
	}
	public Set<UserCommentaireAction> getUserCommentaireAction() {
		return userCommentaireAction;
	}
	public void setUserCommentaireAction(Set<UserCommentaireAction> userCommentaireAction) {
		this.userCommentaireAction = userCommentaireAction;
	}
	public Action(long id_Action, String nom_action, String description_action,
			String lieu_action, Date datedebut_action, Date datefin_action, Calendar datedebut_inscrit,
			Calendar datefin_inscrit, Boolean etat_action, Long nbmembre_action) {
		super();
		this.id_Action = id_Action;
		this.nom_action = nom_action;
		this.description_action = description_action;
		this.lieu_action = lieu_action;
		this.datedebut_action = datedebut_action;
		this.datefin_action = datefin_action;
		this.datedebut_inscrit = datedebut_inscrit;
		this.datefin_inscrit = datefin_inscrit;
		this.etat_action = etat_action;
		this.nbmembre_action = nbmembre_action;
	}
	public Action() {
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
	public Long getNbmembrefixe_action() {
		return nbmembrefixe_action;
	}
	public void setNbmembrefixe_action(Long nbmembrefixe_action) {
		this.nbmembrefixe_action = nbmembrefixe_action;
	}
	public Set<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}
    
     
    
    
    
    
}
