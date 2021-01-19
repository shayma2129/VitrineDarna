package com.darna.dto;

import java.util.Date;

public class UserActionDto {

	
	 Date registeredAt;
	 private Boolean autorisation ;
	

	public UserActionDto( Date registeredAt, Boolean autorisation) {
		super();
		
		this.registeredAt = registeredAt;
		this.autorisation = autorisation;
	}
	
	public UserActionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getRegisteredAt() {
		return registeredAt;
	}
	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}
	public Boolean getAutorisation() {
		return autorisation;
	}
	public void setAutorisation(Boolean autorisation) {
		this.autorisation = autorisation;
	}

	
	  
	  
}
