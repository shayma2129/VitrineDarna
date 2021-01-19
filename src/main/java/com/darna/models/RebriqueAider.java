package com.darna.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Aider")
public class RebriqueAider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
    @Column(name="pk_aider",columnDefinition="TEXT")
	private String pk_aider;
	
	@NotBlank
    @Column(name="comment_aider",columnDefinition="TEXT")
	private String comment_aider;
	
	@NotBlank
    @Column(name="volontariat",columnDefinition="TEXT")
	private String volontariat;

	public RebriqueAider(Long id, @NotBlank String pk_aider, @NotBlank String comment_aider,
			@NotBlank String volontariat) {
		super();
		this.id = id;
		this.pk_aider = pk_aider;
		this.comment_aider = comment_aider;
		this.volontariat = volontariat;
	}

	public RebriqueAider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RebriqueAider(String string, String string2, String string3) {
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
	
	
	
	public Object StringtoString(){
		return "pk-aider: "+getPk_aider()+" comment-aider: "+getComment_aider()+" volontariat: "+getVolontariat();
		}
	

}
