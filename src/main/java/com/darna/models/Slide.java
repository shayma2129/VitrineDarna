package com.darna.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SLIDE")
public class Slide {
	
	/**
	 *  Id slide
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDSlide")
	private long idSlide;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "slide")
   	private Set<Document> documents = new HashSet<>();

	public Slide(long idSlide, Set<Document> documents) {
		super();
		this.idSlide = idSlide;
		this.documents = documents;
	}

	
	public Slide() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getIdSlide() {
		return idSlide;
	}

	public void setIdSlide(long idSlide) {
		this.idSlide = idSlide;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	
	
}
