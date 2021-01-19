package com.darna.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class UserCommentaireAction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commentaire")
	private long id_commentaire;

	  @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
      @JoinColumn(name = "idAction")
	  Action  action;

	  @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	  @JoinColumn(name = "idUser")
	  User user;
	  
	  String commentaire;

	public long getId_commentaire() {
		return id_commentaire;
	}

	public void setId_commentaire(long id_commentaire) {
		this.id_commentaire = id_commentaire;
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

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public UserCommentaireAction( Action action, User user, String commentaire) {
	super();
	this.action = action;
	this.user = user;
	this.commentaire = commentaire;
}

	public UserCommentaireAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCommentaireAction(Action action2, User user2, Object setCommentaire) {
		// TODO Auto-generated constructor stub
	}
	  
}
