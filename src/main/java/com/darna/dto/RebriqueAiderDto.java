package com.darna.dto;


public class RebriqueAiderDto {
	
	private Long id;

	private String pk_aider;
	
	private String comment_aider;
	
	private String volontariat;

	public RebriqueAiderDto(Long id, String pk_aider, String comment_aider, String volontariat) {
		super();
		this.id = id;
		this.pk_aider = pk_aider;
		this.comment_aider = comment_aider;
		this.volontariat = volontariat;
	}

	public RebriqueAiderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPk_aider() {
		return pk_aider;
	}

	public void setPk_aider(String pk_aider) {
		this.pk_aider = pk_aider;
	}

	public String getComment_aider() {
		return comment_aider;
	}

	public void setComment_aider(String comment_aider) {
		this.comment_aider = comment_aider;
	}

	public String getVolontariat() {
		return volontariat;
	}

	public void setVolontariat(String volontariat) {
		this.volontariat = volontariat;
	}
	
	



}
