package com.darna.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.darna.models.pk.UserActionKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class UserAction {
	
	  @EmbeddedId
	  UserActionKey id;

	  @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	  @MapsId("idAction")
	  @JsonIgnoreProperties(value = {"applications"})
	  @JoinColumn(name = "idAction")
	  Action  action;

	  @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	  @MapsId("idUser")
	  @JsonIgnoreProperties(value = {"applications"})
	  @JoinColumn(name = "idUser")
	  User user;

	  Date registeredAt;
	  
	  @Column(name="autorisation")
	  private Boolean autorisation ;

		public UserActionKey getId() {
			return id;
		}

		public void setId(UserActionKey id) {
			this.id = id;
		}

		public Action getAction() {
			return action;
		}

		public void setAction(Action action) {
			this.action = action;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
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

		public UserAction(UserActionKey id, Action action, User user, Date registeredAt, Boolean autorisation) {
			super();
			this.id = id;
			this.action = action;
			this.user = user;
			this.registeredAt = registeredAt;
			this.autorisation = autorisation;
		}

		public UserAction() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

}
