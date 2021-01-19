package com.darna.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OBJECTIF")
public class Objectif {
	/**
	 * Objectif Id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDObjectif")
	private long idObjectif;
    
    /**
     * Description objectif
     */
    @Column(name="description_objectif",length=255)
	private String description_objectif;

	public Objectif(long idObjectif, String description_objectif) {
		super();
		this.idObjectif = idObjectif;
		this.description_objectif = description_objectif;
	}

	public Objectif() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdObjectif() {
		return idObjectif;
	}

	public void setIdObjectif(long idObjectif) {
		this.idObjectif = idObjectif;
	}

	public String getDescription_objectif() {
		return description_objectif;
	}

	public void setDescription_objectif(String description_objectif) {
		this.description_objectif = description_objectif;
	}
    
}
