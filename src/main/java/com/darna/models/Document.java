package com.darna.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="DOCUMENT")
@JsonInclude(value=Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Document {
	
	/**
	 * Id Document
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDDocument")
	private long idDocument;
    
	 /**
     * file
     */
     @Column(name="file")
	 @Lob
	 private byte[] file;
     /**
      * Path Document
      */
     @Column(name="path_doc",length=255)
     private String path_doc;
     
     @ManyToOne
     @JoinColumn(name = "liendoc_id")
     private LienDoc lienDoc;
     
     @ManyToOne
     @JoinColumn(name = "slide_id")
     private Slide slide;

	public Document(long idDocument, byte[] file, String path_doc, LienDoc lienDoc,Slide slide) {
		super();
		this.idDocument = idDocument;
		this.file = file;
		this.path_doc = path_doc;
		this.lienDoc = lienDoc;
		this.slide=slide;
	}

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(long idDocument) {
		this.idDocument = idDocument;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getPath_doc() {
		return path_doc;
	}

	public void setPath_doc(String path_doc) {
		this.path_doc = path_doc;
	}

	public LienDoc getLienDoc() {
		return lienDoc;
	}

	public void setLienDoc(LienDoc lienDoc) {
		this.lienDoc = lienDoc;
	}

	public Slide getSlide() {
		return slide;
	}

	public void setSlide(Slide slide) {
		this.slide = slide;
	}

	
     
}
