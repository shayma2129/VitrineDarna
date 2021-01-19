package com.darna.models.pk;

import java.io.Serializable;

import javax.persistence.Column;

public class UserActionKey  implements Serializable{

	private static final long serialVersionUID = -6704381302698819724L;

	

	@Column(name = "idUser")
	public Long idUser;

	@Column(name = "idAction")
	public Long idAction;
	public UserActionKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Long getIdAction() {
		return idAction;
	}
	public void setIdAction(Long idAction) {
		this.idAction = idAction;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserActionKey(Long idUser, Long idAction) {
		super();
		this.idUser = idUser;
		this.idAction = idAction;
	}
	
	
	
	
}
