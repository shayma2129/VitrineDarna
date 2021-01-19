package com.darna.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name="NOTIFICATION")
public class Notification {
	
	/**
	 * Id notification
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDnotification")
	private long idNotification;
	
	/**
	 * Contenu
	 */
	@Column(name="contenu",length=120)
	private String contenu;
	/**
	 * Contenu
	 */
	@Column(name="consulter")
	private boolean consulter;
	
	@ManyToOne
	@JoinColumn(name = "action_id")
	private Action action;
	
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notification(long idNotification, String contenu, boolean consulter) {
		super();
		this.idNotification = idNotification;
		this.contenu = contenu;
		this.consulter = consulter;
	}
	public Notification(String contenu) {
		super();
		this.contenu = contenu;
	}
	
	public Notification(String contenu, Action action) {
		super();
		this.contenu = contenu;
		this.action = action;
	}
	public long getIdNotification() {
		return idNotification;
	}
	public void setIdNotification(long idNotification) {
		this.idNotification = idNotification;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public boolean isConsulter() {
		return consulter;
	}
	public void setConsulter(boolean consulter) {
		this.consulter = consulter;
	}
	
	
}
